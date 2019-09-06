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
    public boolean addUser(User user){
        boolean isSuccess = false;
        if(userMapper.addUser(user)>0){
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public User login(String phone) {
        return userMapper.login(phone);
    }

    @Override
    public boolean findUserByPhone(String phone) {
        boolean isSuccess = false;
        if(userMapper.findUserByPhone(phone)!= null){
            isSuccess = true;
        }
        return isSuccess;
    }
}
