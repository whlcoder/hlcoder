package com.hlcoder.util;

/**
 * Created by wanghailong on 2016/9/27.
 * 统一响应结构
 */
public class Response {

    private static final String OK = "OK";
    private static final String ERROR = "ERROR";

    private boolean flag ;
    private String msg;
    private Object data;

    public Response(){
        this.flag = true;
        this.msg = OK;
    }

    public Response success(String msg) {
        this.flag = true;
        this.msg = msg;
        return this;
    }

    public Response success(String msg,Object data) {
        this.flag = true;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Response success(Object data) {
        this.data = data;
        return this;
    }

    public Response failure() {
        this.flag = false;
        this.msg = ERROR;
        return this;
    }

    public Response failure(String msg) {
        this.flag = false;
        this.msg = msg;
        return this;
    }

    public Response failure(String msg,Object data) {
        this.flag = false;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public void setData(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }


    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isFlag() {
        return flag;
    }
}
