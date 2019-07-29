package com.myproject.demo.controller;

import com.myproject.demo.entity.Response;
import com.myproject.demo.entity.User;
import com.myproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/getUserItem",method = RequestMethod.GET)
    public String getUserItem(){
        User user = service.getUserInfo();
        return user.toString();
    }

    @RequestMapping(value = "addUserInfo",method = RequestMethod.GET)
    public Response addUserInfo(){
        service.addUserInfo();
        Response response = new Response();
        response.setMsg("添加成功！");
        response.setCode(1);
        return response;
    }

    @RequestMapping(value = "reqister",method = RequestMethod.POST)
    public Response register(@RequestBody Map<String,String> person,HttpServletRequest request){
        String username = person.get("username");

        return null;
    }

    @RequestMapping(value = "/homeInfo",method = RequestMethod.POST)
    public String goHome(Map<String ,Object> paramMap, HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //判断数据是否为空
        if(username != null && password != null && phone != null){
            //判断用户名是否重复
            List<User> users = service.queryByUsername(username);
            if(users != null && users.size()>0){
                int count = service.addUser(username,password,phone);
                if(count>0){
                    paramMap.put("username",username);
                    paramMap.put("password",password);
                    paramMap.put("phone",phone);
                    return "homeInfo";
                }else{
                    paramMap.put("message","未知错误，请联系管理员");
                    return "message";
                }
            }else {
                paramMap.put("message","注册失败，用户名重复");
                return "message";
            }
        }else {
            paramMap.put("message","注册失败，注册信息为空");
            return "message";
        }

    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
