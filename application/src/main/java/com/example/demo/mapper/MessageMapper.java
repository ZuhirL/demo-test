package com.example.demo.mapper;

import com.example.demo.bean.request.Message;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MessageMapper {

    List<Message> getLastHourMessageforAccount(@Param("accountId") int accountId);

    void insertMessage(@Param("message") Message message);

    void insertAlert(@Param("accountId") int accountId, @Param("sum") BigDecimal sum, @Param("alert") String alert);
}
