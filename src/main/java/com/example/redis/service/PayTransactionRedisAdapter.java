package com.example.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class PayTransactionRedisAdapter {

    private final StringRedisTemplate redisTemplate;
    private static final String PREFIX = "transaction:";

    /**
     * Əgər Redis-də yoxdursa, yazır və true qaytarır. Əks halda false.
     */
    public boolean markIfAbsent(String transactionId) {
        String key = PREFIX + transactionId;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        Boolean wasSet = ops.setIfAbsent(key, "1", Duration.ofMinutes(1));
        return Boolean.TRUE.equals(wasSet);
    }
}
