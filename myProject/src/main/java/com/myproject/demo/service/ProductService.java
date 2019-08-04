package com.myproject.demo.service;

import com.myproject.demo.entity.Product;

import java.util.List;

public interface ProductService {
    int addProduct(Product product);
    List<Product> getProductList();
    List<Product> getProductByKey(String productName);
    List<Product> getProductByCondition(String productName,int productType);
    int updateProduct(Product product);
    int deleteProduct(int productId);
}
