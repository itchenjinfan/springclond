package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserDao userDao;


    @Override
    public User findUserById(Integer id) {
        return userDao.findById(id).get();
    }
}
