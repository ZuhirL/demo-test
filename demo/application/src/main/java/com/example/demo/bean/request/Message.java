package com.example.demo.bean.request;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Message {

    private int id;

    @NotNull(message = "Account id can't be blank")
    @Min(value = 1, message = "Account Id must be major than 0")
    private int accountId;

    @Digits(integer = 5, fraction = 2)
    @NotNull(message = "Stake can't be blank")
    @DecimalMin(value = "0.01", message = "Stake must be major than 0")
    private BigDecimal stake;

    private Date time;

    public Message(int accountId, BigDecimal stake) {
        this.id = id;
        this.accountId = accountId;
        this.stake = stake;
        this.time = time;
    }
}
