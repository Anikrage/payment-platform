package com.payment.transaction.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.payment.shared.events.PaymentEvent;
import com.payment.transaction.service.TransactionService;

@Service
public class PaymentEventConsumer {

    private final TransactionService transactionService;
    private final CacheManager cacheManager;

    @Autowired
    public PaymentEventConsumer(TransactionService transactionService, 
                               CacheManager cacheManager) {
        this.transactionService = transactionService;
        this.cacheManager = cacheManager;
    }

    @KafkaListener(
        topics = "payment-events",
        groupId = "transaction-service-group")// Add this line)
    public void consumePaymentEvent(PaymentEvent event) {
        transactionService.saveTransaction(event);
        
        // Clear relevant caches
        cacheManager.getCache("transactions").evict(event.getTransactionId());
        cacheManager.getCache("userTransactions").evict(event.getUserId());
    }
}
