package com.dict.demo.mapper;

import com.dict.demo.entity.Product;
import org.apache.ibatis.annotations.Param;
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

    /**
    功能描述 获取所有非标产品的信息
     * @param null
     * @return  java.util.List<com.dict.demo.entity.Product>
     * @author  CDDX
     * @date  2019/8/28 14:32
     */
    List<Product> getAllIsNotStandardProduct();

    /**
    功能描述 根据 productId 查询是否标准产品
     * @param productId
     * @return  com.dict.demo.entity.Product
     * @author  CDDX
     * @date  2019/8/28 15:03
     */
    Product getIsStandardProduct(@Param("productId")String productId);

}
