package com.dict.demo.controller;

import com.dict.demo.entity.Product;
import com.dict.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
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

    @RequestMapping(value = "goIndex")
    public String getAllServiceScope(Model model){
        List<Product> firstList = productService.getAllServiceScope();
        List<Product> secondList = productService.getAllServiceName();
        List<Product> thirdList = productService.getAllProductName();
        model.addAttribute("secondList",secondList);
        model.addAttribute("firstList",firstList);
        model.addAttribute("thirdList",thirdList);
        return "index";
    }

    @RequestMapping(value = "item")
    public String item(){
        return "item";
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

    @RequestMapping(value = "addProduct")
    @ResponseBody
    public String addProduct(){
        try {
            //获取根目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()){
                path = new File("");
            }
            //找到json文件
            //File json = new File(path.getAbsolutePath(),"static/json/test1.json");
            File json = new File("C:\\Users\\CDDX\\Desktop\\MyJava\\dict\\src\\main\\resources\\static\\json\\test3.json");
            if(!json.exists()){
                System.out.println("文件没有找到");
            }else {
                System.out.println("文件已找到");
                //写入文件内容
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("序号","10003");
                jsonObject.put("服务场景","会议协同");
                jsonObject.put("服务名称","云会议");

                RandomAccessFile raf = new RandomAccessFile(json,"rw");
                raf.seek(json.length()-4);
                byte[] buf = new byte[1];
                raf.read(buf);
                String text = new String(buf);
                String head = ",";
                if(text.equals("}")){
                    System.out.println("一样的");
                    raf.write(head.getBytes());
                }else{
                    System.out.println("不一样的额");
                }
                System.out.println(text);

                String foot="]}}";
                raf.write(jsonObject.toString().getBytes());
                raf.write(foot.getBytes());
                System.out.println(jsonObject);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
