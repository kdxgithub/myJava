package com.myproject.demo.controller;

import com.myproject.demo.entity.Product;
import com.myproject.demo.entity.ProductResponse;
import com.myproject.demo.entity.Response;
import com.myproject.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public Response addProduct(@RequestBody Product product){
        if(product.getProductName() != null && product.getProductPrice() != 0 &&
                product.getProductType() != 0 && product.getProductImg() != null &&
                product.getProductDes() != null){
            int count = productService.addProduct(product);
            if(count > 0){
                Response response = new Response("添加成功",1,true);
                return response;
            }else{
                Response response = new Response("添加失败",-1,false);
                return response;
            }
        }else {
            Response response = new Response("有参数为空",-1,false);
            return response;
        }
    }

    @RequestMapping(value = "/getProductList",method = RequestMethod.POST)
    public ProductResponse getProductList(){
        ProductResponse productResponse = new ProductResponse();
        List<Product> productList = productService.getProductList();
        productResponse.setResponse("查询成功",1,true,productList);
        return productResponse;
    }

    @RequestMapping(value = "/getProductListByKey",method = RequestMethod.POST)
    public ProductResponse getProductListByKey(@RequestBody Map<String,String> product){
        String productName = product.get("productName");
        String productDes = product.get("productDes");
        if(productDes != null){
            productName = productDes;
        }
        ProductResponse productResponse = new ProductResponse();
        List<Product> productList = productService.getProductByKey(productName);
        productResponse.setResponse("查询成功",1,true,productList);
        return productResponse;
    }

    @RequestMapping(value = "/getProductListByCondition",method = RequestMethod.POST)
    public ProductResponse getProductListByCondition(@RequestBody Product product){
        String productName = product.getProductName();
        int productType = product.getProductType();

        ProductResponse productResponse = new ProductResponse();
        List<Product> productList = productService.getProductByCondition(productName,productType);
        productResponse.setResponse("查询成功",1,true,productList);
        return productResponse;
    }

    @RequestMapping(value = "updateProduct",method = RequestMethod.POST)
    public Response updateProduct(@RequestBody Product product){
        int productId = product.getProductId();
        int count = productService.updateProduct(product);
        if(productId !=0){
            if(count>0){
                Response response = new Response("更新成功",1,true);
                return response;
            }else{
                Response response = new Response("更新失败",-1,false);
                return response;
            }
        }else {
            Response response = new Response("请传入商品id",-1,false);
            return response;
        }
    }

    @RequestMapping(value = "deleteProduct",method = RequestMethod.POST)
    public Response deleteProduct(@RequestBody Product product){
        int productId = product.getProductId();
        if(productId !=0){
            int count = productService.deleteProduct(productId);
            if(count>0){
                Response response = new Response("删除成功",1,true);
                return response;
            }else{
                Response response = new Response("删除失败",-1,false);
                return response;
            }
        }else {
            Response response = new Response("删除失败，请传入商品id",-1,false);
            return response;
        }
    }
}
