package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication2.class,args);
    }
}
