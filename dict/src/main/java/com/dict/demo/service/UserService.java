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

    /**
    功能描述:通过手机号查询用户信息
     * @param
     * @return  com.dict.demo.entity.User
     * @author  CDDX
     * @date  2019/9/5 17:20
     */
    User findByPhone(String phone);
}
