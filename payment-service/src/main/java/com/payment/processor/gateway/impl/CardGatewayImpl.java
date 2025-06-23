package com.payment.processor.gateway.impl;

import org.springframework.stereotype.Service;

import com.payment.processor.gateway.PaymentGateway;
import com.payment.processor.model.PaymentRequest;
import com.payment.processor.model.PaymentResponse;
import com.payment.processor.model.RefundRequest;

@Service("cardGateway")
public class CardGatewayImpl implements PaymentGateway {
    private static final String PROVIDER_URL = "https://api.stripe.com/v1/charges";
    
    @Override
    public PaymentResponse pay(PaymentRequest request) {
        // Card tokenization and processing
        return new PaymentResponse("SUCCESS", "Card payment processed");
    }
    
    @Override
    public PaymentResponse refund(RefundRequest request) {
        // Refund logic
        return new PaymentResponse("SUCCESS", "Refund processed");
    }
}
