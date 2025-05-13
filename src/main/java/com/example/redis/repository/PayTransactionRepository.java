package com.example.redis.repository;

import com.example.redis.entity.PayTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayTransactionRepository extends JpaRepository<PayTransaction, Integer> {
    Optional<PayTransaction> findByTransactionId(String transactionId);
}
