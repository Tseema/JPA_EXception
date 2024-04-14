package com.relearn.rest.webservices.restwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {



    private LocalDate timestamp;
    private  String msg;
    private  String details;


    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public ErrorDetails(LocalDate timestamp, String msg, String details) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.details = details;
    }



}
