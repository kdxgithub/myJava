package com.myproject.demo.service;

import com.myproject.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    User getUserInfo();

    void addUserInfo();

    /**
     * 用户注册，添加用户
     * @param username
     * @param password
     * @param phone
     * @return
     */
    int addUser(String username,String password,String phone);

    /**
     * 用户登录，验证用户
     * @param username
     * @return
     */
    List<User> queryByUsername(String username);
}
