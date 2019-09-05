package com.dict.demo.mapper;

import com.dict.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    int addUser(User user);

    /**
     功能描述:通过手机号查询用户信息
     * @param
     * @return  com.dict.demo.entity.User
     * @author  CDDX
     * @date  2019/9/5 17:20
     */
    User findByPhone(@Param("phone") String phone);
}
