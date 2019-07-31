package com.myproject.demo.mapper;

import com.myproject.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int addProduct(Product product);
    List<Product> getProductList();

    List<Product> getProductByKey(String productName);
    List<Product> getProductByCondition(String productName,int productType);
}
