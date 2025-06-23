package com.payment.processor.model;

public class PaymentResponse {
    private String status;
    private String message;
    private String transactionId;

    // Constructors
    public PaymentResponse() {}
    
    public PaymentResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public PaymentResponse(String status, String message, String transactionId) {
        this.status = status;
        this.message = message;
        this.transactionId = transactionId;
    }

    // Getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
