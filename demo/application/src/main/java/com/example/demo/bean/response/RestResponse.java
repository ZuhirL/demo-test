package com.example.demo.bean.response;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RestResponse<T> implements Serializable {

    public static final String SUCCESS = "OK";
    public static final String FAILURE = "KO";

    private String status = "KO";
    private List<ErrorBean> errors = new LinkedList();
    private T payload;

    public RestResponse() {
    }

    public void addError(ErrorBean errorBean) {
        this.errors.add(errorBean);
        this.status = "KO";
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ErrorBean> getErrors() {
        return this.errors;
    }

    public void setErrors(List<ErrorBean> errors) {
        this.errors = errors;
        this.status = "KO";
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public void setSuccess() {
        this.status = "OK";
    }

    public void setFailure() {
        this.status = "KO";
    }
}
