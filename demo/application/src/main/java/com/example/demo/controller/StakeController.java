package com.example.demo.controller;

import com.example.demo.bean.request.Message;
import com.example.demo.facade.MessageFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StakeController {

    @Autowired
    private MessageFacade messageFacade;

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public void getUser(Message message) {
        this.messageFacade.insertMessage(message);
        return;
    }
}
