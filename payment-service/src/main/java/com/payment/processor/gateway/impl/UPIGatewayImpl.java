package com.payment.processor.gateway.impl;

import com.payment.processor.gateway.PaymentGateway;
import com.payment.processor.model.PaymentRequest;
import com.payment.processor.model.PaymentResponse;
import com.payment.processor.model.RefundRequest;

import org.springframework.stereotype.Service;

@Service("upiGateway")
public class UPIGatewayImpl implements PaymentGateway {
    
    @Override
    public PaymentResponse pay(PaymentRequest request) {
        // Implement NPCI UPI API integration
        return new PaymentResponse("SUCCESS", "UPI payment processed");
    }

    @Override
    public PaymentResponse refund(RefundRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }
}
