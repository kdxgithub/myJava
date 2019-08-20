package com.dict.demo.service;

import com.dict.demo.entity.User;

/**
 * 用户service服务类
 * @author CDDX
 */
public interface UserService {
    /**
     * 获取用户信息
     * @return User
     */
    User getUserInfo();

    /**
     * 添加用户
     */
    void addUser();
}
