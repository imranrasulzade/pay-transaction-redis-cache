package com.example.redis.controller;

import com.example.redis.dto.PayTransactionDto;
import com.example.redis.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody PayTransactionDto payload) {
        transactionService.sendTransaction(payload);
        return ResponseEntity.ok("Transaction sent to RabbitMQ");
    }
}
