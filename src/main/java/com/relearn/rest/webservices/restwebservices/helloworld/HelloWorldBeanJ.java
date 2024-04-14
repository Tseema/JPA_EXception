package com.relearn.rest.webservices.restwebservices.helloworld;

public class HelloWorldBeanJ {
    private String msg;

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public HelloWorldBeanJ(String msg) {
        this.msg = msg;
    }
}
