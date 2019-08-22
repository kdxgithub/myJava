package com.dict.demo.mapper;

import com.dict.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    /**
    功能描述:获取所有的服务场景
     * @param null
     * @return java.util.List<com.dict.demo.entity.Product>
     * @author CDDX
     * @date 2019/8/22 16:32
     */
    List<Product> getAllServiceScope();

    /**
    功能描述
     * @param null
     * @return  java.util.List<com.dict.demo.entity.Product>
     * @author  CDDX
     * @date  2019/8/22 16:47
     */
    List<Product> getAllServiceName();

    /**
    功能描述
     * @param null
     * @return  java.util.List<com.dict.demo.entity.Product>
     * @author  CDDX
     * @date  2019/8/22 16:47
     */
    List<Product> getAllProductName();

}
