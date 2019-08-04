package com.myproject.demo.service.impl;

import com.myproject.demo.entity.Product;
import com.myproject.demo.mapper.ProductMapper;
import com.myproject.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        int count = productMapper.addProduct(product);
        return count;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> productList = productMapper.getProductList();
        return productList;
    }

    @Override
    public List<Product> getProductByKey(String productName) {
        List<Product> productList = productMapper.getProductByKey(productName);
        return productList;
    }

    @Override
    public List<Product> getProductByCondition(String productName, int productType) {
        List<Product> productList = productMapper.getProductByCondition(productName,productType);
        return productList;
    }


    /**
     * 更新Product
     * @param product
     * @return
     */
    @Override
    public int updateProduct(Product product){
        int count = 0;
        try{
            count = productMapper.updateProduct(product);
        }catch (Exception err){
            System.out.println(err);
        }

        return count;
    }

    /**
     * 删除Product
     * @param productId
     * @return
     */
    @Override
    public int deleteProduct(int productId) {
        int count = 0;
        try{
            count = productMapper.deleteProduct(productId);
        }catch (Exception err){
            System.out.println(err);
        }
        return count;
    }
}
