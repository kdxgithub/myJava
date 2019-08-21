package com.dict.demo.entity;

public class ServingProduct {
    private int sepId;
    private int sepNumber;
    private String sepScope;
    private String sepName;
    private String sepTagline;

    @Override
    public String toString() {
        return "ServingProduct{" +
                "sepId=" + sepId +
                ", sepNumber=" + sepNumber +
                ", sepScope='" + sepScope + '\'' +
                ", sepName='" + sepName + '\'' +
                ", sepTagline='" + sepTagline + '\'' +
                '}';
    }

    public int getSepId() {
        return sepId;
    }

    public void setSepId(int sepId) {
        this.sepId = sepId;
    }

    public int getSepNumber() {
        return sepNumber;
    }

    public void setSepNumber(int sepNumber) {
        this.sepNumber = sepNumber;
    }

    public String getSepScope() {
        return sepScope;
    }

    public void setSepScope(String sepScope) {
        this.sepScope = sepScope;
    }

    public String getSepName() {
        return sepName;
    }

    public void setSepName(String sepName) {
        this.sepName = sepName;
    }

    public String getSepTagline() {
        return sepTagline;
    }

    public void setSepTagline(String sepTagline) {
        this.sepTagline = sepTagline;
    }


}
