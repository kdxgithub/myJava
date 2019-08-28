package com.dict.demo.entity;
/**
功能描述:产品Bean
 * @Author:CDDX
 * @Date:2019/8/22 16:29
 */
public class Product {
    private int id;
    private String scopeId;
    private String scopeName;
    private String serviceId;
    private String serviceName;
    private String serviceTagline;
    private String productId;
    private String productName;
    private int isStandard;
    private String productFunction;
    private String productFunctionDes;
    private int isPrice;
    private String price;
    private String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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

    public int getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(int isPrice) {
        this.isPrice = isPrice;
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
