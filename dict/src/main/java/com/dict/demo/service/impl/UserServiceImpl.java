package com.dict.demo.service.impl;

import com.dict.demo.entity.User;
import com.dict.demo.mapper.UserMapper;
import com.dict.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfo() {
        return null;
    }
    @Override
    public void addUser(){
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
}
