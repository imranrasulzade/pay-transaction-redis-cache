package com.example.redis.service;

import com.example.redis.dto.PayTransactionDto;
import com.example.redis.entity.PayTransaction;
import com.example.redis.queue.TransactionProducer;
import com.example.redis.repository.PayTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionProducer transactionProducer;
    private final PayTransactionRepository payTransactionRepository;
    private final PayTransactionRedisAdapter redisAdapter;

    public void sendTransaction(PayTransactionDto payload) {
        PayTransaction payTransaction = new PayTransaction();
        payTransaction.setTransactionId(payload.getTransactionId());
        payTransaction.setAmount(payload.getAmount());
        payTransaction.setCurCode(payload.getCurCode());
        payTransaction.setMerchantId(payload.getMerchantId());
        payTransaction.setStatus(payload.getStatus());
        transactionProducer.sendTransaction(payTransaction);
        LOGGER.info("Transaction sent to queue successfully, transactionId: {}", payload.getTransactionId());
    }

    public void saveTransaction(PayTransaction payTransaction) {
        payTransaction.setStatus(2);
        boolean shouldSave = redisAdapter.markIfAbsent(payTransaction.getTransactionId());
        if (!shouldSave) {
            LOGGER.error("Transaction save to db failed for duplicate, transactionId: {}", payTransaction.getTransactionId());
            return;
        }
        payTransactionRepository.save(payTransaction);
        LOGGER.info("Save transaction to db success, transactionId: {}", payTransaction.getTransactionId());
    }
}
