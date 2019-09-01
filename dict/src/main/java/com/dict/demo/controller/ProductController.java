package com.dict.demo.controller;

import com.dict.demo.entity.Product;
import com.dict.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类描述：产品类控制器
 *
 * @author KDX
 * @version V1.0
 * @date 2019/8/22 16:49
 **/
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "getAllServiceScope")
    public String getAllServiceScope(Model model){
        List<Product> firstList = productService.getAllServiceScope();
        List<Product> secondList = productService.getAllServiceName();
        List<Product> thirdList = productService.getAllProductName();
        model.addAttribute("secondList",secondList);
        model.addAttribute("firstList",firstList);
        model.addAttribute("thirdList",thirdList);
        return "index";
    }

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "item")
    public String item(){
        return "item";
    }

    @RequestMapping(value = "test")
    public String test(Model model){
        List<Product> firstList = productService.getAllServiceScope();
        List<Product> secondList = productService.getAllServiceName();
        List<Product> thirdList = productService.getAllProductName();
        model.addAttribute("secondList",secondList);
        model.addAttribute("firstList",firstList);
        model.addAttribute("thirdList",thirdList);

        return "test";
    }

    @RequestMapping(value = "getSecondList")
    @ResponseBody
    public List<Product> getSecondList(){
        List<Product> secondList = productService.getAllServiceName();
        return secondList;
    }

    @RequestMapping(value = "getThirdList")
    @ResponseBody
    public List<Product> getThirdList(){
        List<Product> thirdList = productService.getAllProductName();
        return thirdList;
    }

    @RequestMapping(value = "getAllIsNotStandardProduct")
    @ResponseBody
    public List<Product> getAllIsNotStandardProduct(){
        List<Product> isStandardList = productService.getAllProductName();
        return isStandardList;
    }

    @RequestMapping(value = "getIsStandardProduct")
    @ResponseBody
    public Product getIsStandardProduct(String productName){
        Product product = productService.getIsStandardProduct(productName);
        return product;
    }
}
