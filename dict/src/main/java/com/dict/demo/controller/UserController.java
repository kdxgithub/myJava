package com.dict.demo.controller;

import com.dict.demo.entity.User;
import com.dict.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/findByPhone")
    public String findByPhone(){

        return null;
    }


//    @RequestMapping(value = "/getUserItem",method = RequestMethod.GET)
//    public String getUserItem(){
//        User user = userService.getUserInfo();
//        return  user.toString();
//    }
//
//    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
//    public String addUser(){
//        userService.addUser();
//        System.out.println("注册成功！");
//        return null;
//    }
}
