package com.example.demo.facade;

import com.example.demo.bean.request.Message;
import com.example.demo.bean.response.Alert;
import com.example.demo.dao.MessageDao;
import com.example.demo.service.CheckBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageFacade {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private CheckBeanService checkBeanService;

    private SimpMessagingTemplate template;

    @Autowired
    public MessageFacade(SimpMessagingTemplate template) {
        this.template = template;
    }


    public void insertMessage(Message message) {

        checkBeanService.checkBeanFormat(message);

        messageDao.insertMessage(message);
        List<Message> messageList = messageDao.getLastHourMessageforAccount(message.getAccountId());

        BigDecimal sum = messageList.stream().map(Message::getStake).reduce(BigDecimal.ZERO, (a, b) -> a.add(b) );

        if (sum.compareTo(BigDecimal.valueOf(100)) > 0) {
            String alert = "User Id " + message.getId() + " has a stake of " + new DecimalFormat("#.##").format(sum) + " at time " + new Date();
            this.messageDao.insertAlert(message.getAccountId(), sum, alert);
            this.template.convertAndSend("/topic/user", new Alert(alert));
        }

    }

}
