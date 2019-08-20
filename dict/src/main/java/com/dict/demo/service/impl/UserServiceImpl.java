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
        User user = new User();
        user.setUserName("hahah");
        user.setUserNickname("asdasdad");
        return user;
    }
    @Override
    public void addUser(){
        String username = "kkk";
        String password = "666888";
        int state = 1;
        String phone = "18899992222";
        String nickname = "小可可";

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        user.setUserState(state);
        user.setUserPhone(phone);
        user.setUserNickname(nickname);
        userMapper.addUser(user);
    }
}
