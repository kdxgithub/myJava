package com.dict.demo.service.impl;

import com.dict.demo.entity.Product;
import com.dict.demo.mapper.ProductMapper;
import com.dict.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return productMapper.getAllServiceScope();
    }

    @Override
    public List<Product> getAllProductName() {
        return productMapper.getAllProductName();
    }
}
