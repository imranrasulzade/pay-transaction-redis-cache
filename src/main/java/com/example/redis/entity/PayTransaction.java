package com.example.redis.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "pay_transactions")
public class PayTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String transactionId;

    private BigDecimal amount;
    private Integer curCode;
    private Integer merchantId;
    private Integer status;
}
