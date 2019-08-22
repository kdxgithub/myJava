package com.dict.demo.entity;
/**
功能描述:产品Bean
 * @Author:CDDX
 * @Date:2019/8/22 16:29
 */
public class Product {
    private int id;
    private int serviceId;
    private String serviceScope;
    private String serviceName;
    private String serviceTagline;
    private int productId;
    private String productName;
    private int isStandard;
    private String productFunction;
    private String productFunctionDes;
    private String price;
    private String label;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceScope() {
        return serviceScope;
    }

    public void setServiceScope(String serviceScope) {
        this.serviceScope = serviceScope;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceTagline() {
        return serviceTagline;
    }

    public void setServiceTagline(String serviceTagline) {
        this.serviceTagline = serviceTagline;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(int isStandard) {
        this.isStandard = isStandard;
    }

    public String getProductFunction() {
        return productFunction;
    }

    public void setProductFunction(String productFunction) {
        this.productFunction = productFunction;
    }

    public String getProductFunctionDes() {
        return productFunctionDes;
    }

    public void setProductFunctionDes(String productFunctionDes) {
        this.productFunctionDes = productFunctionDes;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
