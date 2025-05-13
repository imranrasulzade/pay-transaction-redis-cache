package com.example.redis.controller;

import com.example.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("temp")
    public void saveTemp(@RequestParam String userId, @RequestParam String otp) {
        redisService.set(userId, otp, 60L);
    }

    @PostMapping
    public void save(@RequestParam String userId, @RequestParam String otp) {
        redisService.set(userId, otp);
    }

    @GetMapping
    public Optional<String> get(@RequestParam String userId) {
        return redisService.get(userId);
    }

    @GetMapping("/exists")
    public Boolean exists(@RequestParam String userId) {
        return redisService.exists(userId);
    }

    @DeleteMapping
    public void delete(@RequestParam String userId) {
        redisService.delete(userId);
    }
}
