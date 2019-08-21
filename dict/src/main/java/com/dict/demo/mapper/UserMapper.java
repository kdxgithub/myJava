package com.dict.demo.mapper;

import com.dict.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    int addUser(User user);
}
