package com.example.redis.queue;

import com.example.redis.configs.RabbitConfig;
//import com.example.redis.configs.RabbitConfigOld;
import com.example.redis.entity.PayTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionProducer {

    private final RabbitTemplate rabbitTemplate;


    public void sendTransaction(PayTransaction transaction) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                transaction
        );
    }
}
