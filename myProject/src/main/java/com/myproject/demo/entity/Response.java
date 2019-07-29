package com.myproject.demo.entity;

public class Response {
    String msg;
    int code;
    Boolean isSuccess = true;

    public Response() {
    }

    public Response(String msg, int code, Boolean isSuccess) {
        this.msg = msg;
        this.code = code;
        this.isSuccess = isSuccess;
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
