package com.myproject.demo.service.impl;

import com.myproject.demo.entity.User;
import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserInfo() {
        User user = new User();
        user.setUsername("sssss");
        user.setPassword("666888");
        return user;
    }

    @Autowired
    UserMapper userMapper;
    @Override
    public void addUserInfo() {
        String username = "kdxkdxKKKDDDXX";
        String password = "88882221111";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.addUserInfo(user);
    }

    @Override
    public int addUser(String username, String password, String phone) {
        User user = new User(username,password,phone);
        int count = userMapper.addUser(user);
        return count;
    }

    @Override
    public List<User> queryByUsername(String username) {
        List<User> userList = userMapper.queryByUsername(username);
        return userList;
    }
}
