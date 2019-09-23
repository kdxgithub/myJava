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

    /**
     功能描述 获取所有非标产品的信息
     * @param null
     * @return  java.util.List<com.dict.demo.entity.Product>
     * @author  CDDX
     * @date  2019/8/28 14:32
     */
    List<Product> getAllIsNotStandardProduct();

    /**
     功能描述 根据 productName 查询是否标准产品
     * @param productName
     * @return  com.dict.demo.entity.Product
     * @author  CDDX
     * @date  2019/8/28 15:03
     */
    Product getIsStandardProduct(String productName);



}
