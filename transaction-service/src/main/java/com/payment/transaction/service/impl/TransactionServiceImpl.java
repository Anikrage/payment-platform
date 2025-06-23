package com.payment.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.shared.events.PaymentEvent;
import com.payment.transaction.model.Transaction;
import com.payment.transaction.repository.TransactionRepository;
import com.payment.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId);
    }

    @Override
    public List<Transaction> getUserTransactions(String userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public void saveTransaction(PaymentEvent event) {
        Transaction transaction = new Transaction();
        transaction.setId(event.getTransactionId());
        transaction.setUserId(event.getUserId());
        transaction.setAmount(event.getAmount());
        transaction.setCurrency(event.getCurrency());
        transaction.setStatus(event.getStatus());
        transaction.setPaymentMethod(event.getPaymentMethod());
        transaction.setCreatedAt(java.time.Instant.now());
        transactionRepository.save(transaction);
    }
}
