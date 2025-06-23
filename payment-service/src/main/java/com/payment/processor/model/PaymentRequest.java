package com.payment.processor.model;

import java.math.BigDecimal;

public class PaymentRequest {
    private PaymentMethod paymentMethod; // Changed from String to PaymentMethod
    private BigDecimal amount;
    private String userId;

    // Getters and setters
    public PaymentMethod getPaymentMethod() { 
        return paymentMethod; 
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) { 
        this.paymentMethod = paymentMethod; 
    }
    public BigDecimal getAmount() { 
        return amount; 
    }
    public void setAmount(BigDecimal amount) { 
        this.amount = amount; 
    }
    public String getUserId() { 
        return userId; 
    }
    public void setUserId(String userId) { 
        this.userId = userId; 
    }
}
