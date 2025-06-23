package com.payment.transaction.service;

import com.payment.transaction.model.Transaction;
import com.payment.shared.events.PaymentEvent;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Optional<Transaction> getTransactionById(String transactionId);
    List<Transaction> getUserTransactions(String userId);
    void saveTransaction(PaymentEvent event);
}
