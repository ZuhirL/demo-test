package com.example.demo.service;

import com.example.demo.exception.error.BeanFieldException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CheckBeanService {

    public <T> void checkBeanFormat(T bean) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(bean);
        if (violations.size() > 0) {
            List<String> errors = new ArrayList<>();
            for (ConstraintViolation c : violations) {
                errors.add(c.getMessage());
            }
            throw new BeanFieldException(errors);
        }
    }

}

