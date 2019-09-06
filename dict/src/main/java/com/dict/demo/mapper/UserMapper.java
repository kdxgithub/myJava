package com.dict.demo.mapper;

import com.dict.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    int addUser(User user);

    /**
     功能描述:通过phone验证用户登录，并返回用户信息
     * @param phone
     * @return  com.dict.demo.entity.User
     * @author  CDDX
     * @date  2019/9/6 9:33
     */
    User login(@Param("phone") String phone);
    /**
    功能描述:根据phone来查找用户是否存在
     * @param phone
     * @return  com.dict.demo.entity.User
     * @author  CDDX
     * @date  2019/9/6 14:48
     */
    User findUserByPhone(@Param("phone") String phone);
}
