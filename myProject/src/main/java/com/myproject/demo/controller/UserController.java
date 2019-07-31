package com.myproject.demo.controller;

import com.myproject.demo.entity.Response;
import com.myproject.demo.entity.User;
import com.myproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserItem",method = RequestMethod.GET)
    public String getUserItem(){
        User user = userService.getUserInfo();
        return user.toString();
    }

    @RequestMapping(value = "addUserInfo",method = RequestMethod.GET)
    public Response addUserInfo(){
        userService.addUserInfo();
        Response response = new Response();
        response.setMsg("添加成功！");
        response.setCode(1);
        return response;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String goHome(Map<String ,Object> paramMap, HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //判断数据是否为空
        if(username != null && password != null && phone != null){
            //判断用户名是否重复
            List<User> users = userService.queryByUsername(username);
            if(users != null && users.size()>0){
                paramMap.put("message","注册失败，用户名重复");
                return "message";
            }else {
                int count = userService.addUser(username,password,phone);
                if(count>0){
                    paramMap.put("username",username);
                    paramMap.put("password",password);
                    paramMap.put("phone",phone);
                    return "homeInfo";
                }else{
                    paramMap.put("message","未知错误，请联系管理员");
                    return "message";
                }
            }
        }else {
            paramMap.put("message","注册失败，注册信息为空");
            return "message";
        }

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Map<String ,Object> paramMap, HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //1、判断用户名、密码是否为空
        if(username != null && password !=null){
            //2、判断用户名是否存在
            List<User> users = userService.queryByUsername(username);
            if(users != null && users.size()>0){
                User user = users.get(0);
                //3、判断密码是否正确
                if(password.equals(user.getPassword()) ){
                    paramMap.put("message","登录成功！");
                    return "message";
                }else {
                    System.out.println(password);
                    System.out.println(user.getPassword());
                    paramMap.put("message","密码不正确，请重新输入");
                    return "message";
                }
            }else {
                paramMap.put("message","用户名不存在");
                return "message";
            }
        }else {
            paramMap.put("message","用户名、密码不能为空");
            return "message";
        }
    }

    @RequestMapping("/goRegister")
    public String goRegister(){
        return "register";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }
}
