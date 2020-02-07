package com.example.demo.exception;

import com.example.demo.bean.response.ErrorBean;
import com.example.demo.bean.response.RestResponse;
import com.example.demo.exception.error.BeanFieldException;
import com.example.demo.exception.error.GenericException;
import com.example.demo.exception.error.TableQueryException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionErrorHandler extends ResponseEntityExceptionHandler {

    private RestResponse setError(String codeError, String e) {
        RestResponse restResponse = new RestResponse();
        restResponse.setFailure();
        ErrorBean error = new ErrorBean();
        error.setCode(codeError);
        error.setDescription(e);
        List<ErrorBean> list = new ArrayList<>();
        list.add(error);
        restResponse.setErrors(list);
        return restResponse;
    }

    private RestResponse setErrorList(String codeError, List<String> errorList) {
        RestResponse restResponse = new RestResponse();
        restResponse.setFailure();
        List<ErrorBean> list = new ArrayList<>();
        for (String err : errorList) {
            ErrorBean error = new ErrorBean();
            error.setCode(codeError);
            error.setDescription(err);
            list.add(error);
        }
        restResponse.setErrors(list);
        return restResponse;
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleGenericException(GenericException e) {
        RestResponse restResponse = setError("ERR00", e.getMessage());
        return new ResponseEntity<>(restResponse, HttpStatus.valueOf(500));
    }

    @ExceptionHandler(TableQueryException.class)
    public ResponseEntity<?> handleTableQueryException(TableQueryException e) {
        RestResponse restResponse = setError("ERR01", e.getMessage());
        return new ResponseEntity<>(restResponse, HttpStatus.valueOf(500));
    }

    @ExceptionHandler(BeanFieldException.class)
    public ResponseEntity<?> handleEmailFormatExceptionn(BeanFieldException e) {
        RestResponse restResponse = setErrorList("ERR02", e.getErrors());
        return new ResponseEntity<>(restResponse, HttpStatus.valueOf(400));
    }
}
