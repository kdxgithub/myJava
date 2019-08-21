package com.dict.demo.controller;

import com.dict.demo.entity.ServingProduct;
import com.dict.demo.service.ServingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    ServingProductService servingProductService;

    @RequestMapping(value = "/index")
    public String demo(){
        return "index";
    }

    @RequestMapping(value = "/findAll")
    public String findAll(Model model){
        List<ServingProduct> list = servingProductService.getServingProductList();
        model.addAttribute("info",list);
        return "index";
    }


}
