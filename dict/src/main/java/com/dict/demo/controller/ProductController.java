package com.dict.demo.controller;

import com.dict.demo.entity.Product;
import com.dict.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    public String addProduct(HttpServletRequest request){
        try {
            //获取根目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()){
                path = new File("");
            }
            //找到json文件
            File json = new File(path.getAbsolutePath(),"static/json/test1.json");
            //File json = new File("C:\\Users\\CDDX\\Desktop\\MyJava\\dict\\src\\main\\resources\\static\\json\\test3.json");
            if(!json.exists()){
                System.out.println("文件没有找到");
            }else {
                System.out.println("文件已找到");
                //获取服务器上传的json
                String jsonStr = productService.getJSON(request);
                //上传
                System.out.println(jsonStr);
                if(jsonStr.length()>0){
                    String counts = request.getParameter("counts");
                    productService.uploadJSON(json,jsonStr,counts);
                }
                //返回数据
                BufferedReader reader = new BufferedReader(new FileReader(json));
                String tempStr;
                StringBuffer stringBuffer = new StringBuffer();
                while((tempStr = reader.readLine()) != null){
                    stringBuffer.append(tempStr);
                }
                reader.close();

                return stringBuffer.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "showProduct")
    @ResponseBody
    public String showProduct(HttpServletRequest request){
        StringBuffer stringBuffer = new StringBuffer();

        return null;
    }
}
