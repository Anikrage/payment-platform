package com.payment.processor.gateway.impl;

import com.payment.processor.gateway.PaymentGateway;
import com.payment.processor.model.PaymentRequest;
import com.payment.processor.model.PaymentResponse;
import com.payment.processor.model.RefundRequest;

import org.springframework.stereotype.Service;

@Service("walletGateway")
public class WalletGatewayImpl implements PaymentGateway {
    
    @Override
    public PaymentResponse pay(PaymentRequest request) {
        // Implement wallet provider integration
        return new PaymentResponse("SUCCESS", "Wallet payment processed");
    }

    @Override
    public PaymentResponse refund(RefundRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }
}
