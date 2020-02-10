package com.example.demo.controller;

import com.example.demo.bean.request.Message;
import com.example.demo.bean.response.RestResponse;
import com.example.demo.facade.MessageFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MessageController {

    @Autowired
    private MessageFacade messageFacade;

    @PostMapping(value = "/message")
    public ResponseEntity<?> insertUser(@RequestBody Message message) {

        messageFacade.insertMessage(message);

        RestResponse<?> restResponse = new RestResponse<>();
        restResponse.setSuccess();

        return new ResponseEntity(restResponse, HttpStatus.OK);
    }

}
