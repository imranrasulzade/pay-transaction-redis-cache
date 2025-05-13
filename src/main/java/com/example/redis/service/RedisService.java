package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;
    private final ValueOperations<String, String> valueOps;

    @Autowired
    public RedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.valueOps = stringRedisTemplate.opsForValue();
    }

    public void set(String key, String value) {
        valueOps.set(key, value);
    }

    public void set(String key, String value, long timeoutSeconds) {
        valueOps.set(key, value, Duration.ofSeconds(timeoutSeconds));
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(valueOps.get(key));
    }

    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    public boolean exists(String key) {
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
    }
}

