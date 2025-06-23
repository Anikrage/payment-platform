package com.payment.processor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.processor.gateway.GatewayFactory;
import com.payment.processor.model.PaymentRequest;
import com.payment.processor.model.PaymentResponse;

@Service
public class PaymentService {
    private final GatewayFactory gatewayFactory;

    @Autowired
    public PaymentService(GatewayFactory gatewayFactory) {
        this.gatewayFactory = gatewayFactory;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        // No need to convert String to PaymentMethod, it's already the correct type
        return gatewayFactory.getGateway(request.getPaymentMethod()).pay(request);
    }
}
