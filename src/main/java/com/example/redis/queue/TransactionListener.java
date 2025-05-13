package com.example.redis.queue;

import com.example.redis.configs.RabbitConfig;
import com.example.redis.entity.PayTransaction;
import com.example.redis.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionListener.class);
    private final TransactionService transactionService;

    @SneakyThrows
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiveTransaction(PayTransaction transaction) {
        LOGGER.info("Received Transaction: {}", transaction);
        transactionService.saveTransaction(transaction);
    }
}
