package com.payment.processor.gateway;

import com.payment.processor.model.PaymentRequest;
import com.payment.processor.model.PaymentResponse;
import com.payment.processor.model.RefundRequest;

public interface PaymentGateway {
    PaymentResponse pay(PaymentRequest request);
    PaymentResponse refund(RefundRequest request);
}
