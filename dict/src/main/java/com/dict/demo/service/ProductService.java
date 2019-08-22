package com.dict.demo.service;

import com.dict.demo.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     功能描述:获取所有的服务场景
     * @param null
     * @return:java.util.List<com.dict.demo.entity.Product>
     * @Author:CDDX
     * @Date:2019/8/22 16:32
     */
    List<Product> getAllServiceScope();

    /**
     功能描述 获取所有的服务名称
     * @param null
     * @return:java.util.List<com.dict.demo.entity.Product>
     * @Author:CDDX
     * @Date:2019/8/22 16:34
     */
    List<Product> getAllServiceName();

    /**
     功能描述:获取所有的产品名称
     * @param
     * @return:java.util.List<com.dict.demo.entity.Product>
     * @Author:CDDX
     * @Date:2019/8/22 16:35
     */
    List<Product> getAllProductName();
}
