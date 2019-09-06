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
    boolean addUser(User user);

    /**
    功能描述:通过phone查找用户，并返回用户信息用于验证登录
     * @param phone
     * @return  com.dict.demo.entity.User
     * @author  CDDX
     * @date  2019/9/6 9:33
     */
    User login(String phone);
    /**
     功能描述:根据phone来查找用户是否存在
     * @param phone
     * @return  boolean
     * @author  CDDX
     * @date  2019/9/6 14:48
     */
    boolean findUserByPhone(String phone);
}
