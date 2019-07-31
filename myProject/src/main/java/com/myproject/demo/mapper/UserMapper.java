package com.myproject.demo.mapper;

import com.myproject.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int addUserInfo(User user);

    int addUser(User user);

    List<User> queryByUsername(String username);


}
