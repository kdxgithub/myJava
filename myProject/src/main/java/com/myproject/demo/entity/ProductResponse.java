package com.myproject.demo.entity;

public class ProductResponse {
    String msg;
    int code;
    Boolean isSuccess = true;
    Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ProductResponse() {
    }

    public ProductResponse(String msg, int code, Boolean isSuccess, Object result) {
        this.msg = msg;
        this.code = code;
        this.isSuccess = isSuccess;
        this.result = result;
    }

    public void setResponse(String msg, int code, Boolean isSuccess, Object result) {
        this.msg = msg;
        this.code = code;
        this.isSuccess = isSuccess;
        this.result = result;
    }


    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
