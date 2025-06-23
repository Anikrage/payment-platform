package com.payment.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.transaction.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> { // Changed to String
    List<Transaction> findByUserId(String userId);
}
