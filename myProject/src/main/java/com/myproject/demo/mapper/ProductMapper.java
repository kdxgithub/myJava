package com.myproject.demo.mapper;

import com.myproject.demo.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int addProduct(Product product);
    List<Product> getProductList();

    List<Product> getProductByKey(String productName);
    List<Product> getProductByCondition(@Param("productName") String productName,@Param("productType") int productType);
    int updateProduct(@Param("pro") Product product);

    int deleteProduct(int productId);
}
