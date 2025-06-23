package com.payment.shared.events;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentEvent {
    private String transactionId;
    private String userId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String paymentMethod;
    private final Instant timestamp = Instant.now();

    public PaymentEvent() {}

    public PaymentEvent(String transactionId, String userId, BigDecimal amount, 
                       String currency, String status, String paymentMethod) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    // Getters and setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    
    public Instant getTimestamp() { return timestamp; }
}
