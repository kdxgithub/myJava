package com.dict.demo.controller;

import com.dict.demo.entity.User;
import com.dict.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginUI")
    public String loginUI(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User user = userService.login(phone);
        if(user != null){
            if(user.getPassword().equals(password)){
                model.addAttribute("user",user);
                return "forward:goIndex";
            }else{
                model.addAttribute("phone",phone);
                model.addAttribute("password","");
                model.addAttribute("passMessage","密码不正确，请重新输入");
                model.addAttribute("phoneMessage","");
                return "login";
            }
        }else{
            model.addAttribute("phoneMessage","手机号不存在，请重新输入");
            model.addAttribute("passMessage","");
            return "login";
        }
    }

    @RequestMapping(value = "outLogin")
    public String outLogin(Model model){
        model.addAttribute("user","");
        return "login";
    }

    @RequestMapping(value = "registerUI")
    public String registerUI(){
        return "register";
    }

    @RequestMapping(value = "register")
    public String register(HttpServletRequest request,Model model){
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);

        if(userService.findUserByPhone(phone)){
            model.addAttribute("phoneMessage","手机号已注册，请重新输入");
            model.addAttribute("password","");
            return "register";
        }else {
            userService.addUser(user);
            model.addAttribute("phone",phone);
            model.addAttribute("password",password);
            return "login";
        }
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
