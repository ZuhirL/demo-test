package com.example.demo.exception.error;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BeanFieldException extends RuntimeException {

    @Getter
    List<String> errors = new ArrayList<>();

    public BeanFieldException(List<String> listErrors) {
        for(String er: listErrors) {
            errors.add(er);
        }
    }
}
