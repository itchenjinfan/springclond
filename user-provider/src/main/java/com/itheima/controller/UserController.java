package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/find/{id}")
    public User findUserById(@PathVariable(value = "id")Integer id){
        if (id==1){
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            throw new RuntimeException("未知错误");
        }
        User user=userService.findUserById(id);
        user.setUsername("user-privider");
        return user;
    }
}
