package com.payment.processor.statemachine;

public enum PaymentState {
    INITIATED, VALIDATED, PROCESSING, COMPLETED, FAILED
}
