package com.dict.demo.service.impl;

import com.dict.demo.entity.Product;
import com.dict.demo.mapper.ProductMapper;
import com.dict.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

/** 产品业务的实现
 * @author KDX
 * @date 2019/8/22 16:38
 * @version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> getAllServiceScope() {
        return productMapper.getAllServiceScope();
    }

    @Override
    public List<Product> getAllServiceName() {
        return productMapper.getAllServiceName();
    }

    @Override
    public List<Product> getAllProductName() {
        return productMapper.getAllProductName();
    }

    @Override
    public List<Product> getAllIsNotStandardProduct() {
        return productMapper.getAllIsNotStandardProduct();
    }

    @Override
    public Product getIsStandardProduct(String productName) {
        return productMapper.getIsStandardProduct(productName);
    }

    @Override
    public String getJSON(HttpServletRequest request) {
        StringBuffer jsonData = new StringBuffer();
        String line;
        try{
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine())!= null){
                jsonData.append(line);
            }
            if(jsonData.length()>0){
                System.out.println("json数据已找到："+jsonData.toString());
            }else{
                System.out.println("没有数据");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return jsonData.toString();
    }

    @Override
    public void uploadJSON(File json,String jsonStr,String counts) {
        try{
            RandomAccessFile raf = new RandomAccessFile(json,"rw");
            raf.seek(json.length()-4);
            byte[] buf = new byte[1];
            raf.read(buf);
            String text = new String(buf);
            String head = ",";
            if(text.equals("}")){
                raf.write(head.getBytes());
            }
            String foot=",\"合计\":\""+counts+"\"}]}}";
            raf.write(jsonStr.getBytes());
            raf.seek(raf.length()-1);
            raf.write(foot.getBytes());
            System.out.println("成功上传");
            raf.close();
        }catch (Exception e){
            System.out.println("上传失败，原因："+e.toString());
        }
    }
}
