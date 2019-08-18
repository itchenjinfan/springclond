package com.itheima.controller;

import com.itheima.pojo.User;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/comsumer")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    //注册中心
    @Autowired
    private DiscoveryClient discoveryClient;
//    服务降级方法
    @HystrixCommand(fallbackMethod = "failBack")
    @RequestMapping("/getuser/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
//        String url="http://localhost:18081/user/find/"+id;

        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        ServiceInstance serviceInstance = instances.get(0);
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/find/" + id;
        String url="http://user-provider/user/find/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    /**
     * 服务降级方法
     * @return
     */
    public User failBack(Integer id){
      User user=new User();
      user.setUsername("服务降级");
      return user;
    }
}
