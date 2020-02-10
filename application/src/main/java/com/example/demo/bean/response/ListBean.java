package com.example.demo.bean.response;

import java.util.List;

public class ListBean {

    private List<?> list;

    public ListBean(List<?> list) {
        this.list = list;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
