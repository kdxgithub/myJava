package com.dict.demo.mapper;

import com.dict.demo.entity.ServingProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServingProductMapper {
    List<ServingProduct> getServingProductList();
}
