package com.example.redis.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayTransactionDto {
    private Integer id;
    private String transactionId;
    private BigDecimal amount;
    private Integer curCode;
    private Integer merchantId;
    private Integer status;
}

/**
 {
 "transactionId": "98455489",
 "amount": 10.00,
 "curCode": 944,
 "merchantId": 12,
 "status": 1
 }
 **/
