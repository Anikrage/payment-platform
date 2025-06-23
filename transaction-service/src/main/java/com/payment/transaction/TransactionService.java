package com.payment.transaction;

import java.util.List;
import java.util.Optional;

import com.payment.shared.events.PaymentEvent;
import com.payment.transaction.model.Transaction;

public interface TransactionService {
    Optional<Transaction> getTransactionById(String transactionId);
    List<Transaction> getUserTransactions(String userId);
    void saveTransaction(PaymentEvent event);
}
