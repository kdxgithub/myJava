package com.dict.demo.service.impl;

import com.dict.demo.entity.ServingProduct;
import com.dict.demo.mapper.ServingProductMapper;
import com.dict.demo.service.ServingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServingProductServiceImpl implements ServingProductService {
    @Autowired
    ServingProductMapper servingProductMapper;

    @Override
    public List<ServingProduct> getServingProductList(){
        List<ServingProduct> productList = servingProductMapper.getServingProductList();
        return  productList;
    }
}
