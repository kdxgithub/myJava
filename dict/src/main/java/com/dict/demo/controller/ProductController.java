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
import java.io.*;
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
            //找到json文件,为每个用户创建一个临时文件夹
            String userName = request.getParameter("username");
            String fileDir = "static\\temp\\";
            String fileName = fileDir+userName+".json";
            File json = new File(path.getAbsolutePath(),fileName);
            File jsonDir = new File(path.getAbsolutePath(),fileDir);
            if(!json.exists()){
                if(!jsonDir.exists()){
                    jsonDir.mkdirs();
                }
                json.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(json));
                String initJSON = "{\n" +
                        "  \"status\": 200\n" +
                        ",\"message\": \"\"\n" +
                        ",\"total\": 1000\n" +
                        ",\"rows\": {\n" +
                        "  \"item\": [\n" +
                        "    ]}}";
                writer.write(initJSON);
                writer.flush();
                writer.close();
            }
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

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "clearProduct")
    @ResponseBody
    public String showProduct(HttpServletRequest request){
        try{
            //获取根目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()){
                path = new File("");
            }
            //找到json文件,为每个用户创建一个临时文件夹
            String userName = request.getParameter("username");
            String fileDir = "static\\temp\\";
            String fileName = fileDir+userName+".json";
            File json = new File(path.getAbsolutePath(),fileName);
            File jsonDir = new File(path.getAbsolutePath(),fileDir);
            if(!json.exists()){
                if(!jsonDir.exists()){
                    jsonDir.mkdirs();
                }
                json.createNewFile();
            }
            productService.clearJSON(json);
            System.out.println("清除成功");
            return "清除成功";
        }catch (Exception e){
            System.out.println("清除失败："+e.toString());
        }
        return null;
    }
}
