package com.payment.processor.gateway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.payment.processor.model.PaymentMethod;

@Service
public class GatewayFactory {

    private final PaymentGateway upiGateway;
    private final PaymentGateway cardGateway;
    private final PaymentGateway walletGateway;

    @Autowired
    public GatewayFactory(
            @Qualifier("upiGateway") PaymentGateway upiGateway,
            @Qualifier("cardGateway") PaymentGateway cardGateway,
            @Qualifier("walletGateway") PaymentGateway walletGateway
    ) {
        this.upiGateway = upiGateway;
        this.cardGateway = cardGateway;
        this.walletGateway = walletGateway;
    }

    public PaymentGateway getGateway(PaymentMethod method) {
        return switch (method) {
            case UPI -> upiGateway;
            case CARD -> cardGateway;
            case WALLET -> walletGateway;
            default -> throw new IllegalArgumentException("Invalid payment method: " + method);
        };
    }
}
