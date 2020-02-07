package com.example.demo.bean.response;

public class ErrorBean {
    protected String code;
    protected String description;
    protected String params;

    public ErrorBean() {
    }

    public ErrorBean(String code, String description, String params) {
        this.code = code;
        this.description = description;
        this.params = params;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}