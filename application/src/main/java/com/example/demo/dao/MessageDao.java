package com.example.demo.dao;

import com.example.demo.bean.request.Message;
import com.example.demo.exception.error.TableQueryException;
import com.example.demo.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MessageDao {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getLastHourMessageforAccount(int accountId) {
        try {
            List<Message> list = messageMapper.getLastHourMessageforAccount(accountId);
            return list;
        } catch (Exception e) {
            throw new TableQueryException();
        }
    }

    public void insertMessage(Message message) {
        try {
            messageMapper.insertMessage(message);
        } catch (Exception e) {
            throw new TableQueryException();
        }
    }


    public void insertAlert(int accountId, BigDecimal sum, String alert) {
        try {
            messageMapper.insertAlert(accountId, sum, alert);
        } catch (Exception e) {
            throw new TableQueryException();
        }
    }
}
