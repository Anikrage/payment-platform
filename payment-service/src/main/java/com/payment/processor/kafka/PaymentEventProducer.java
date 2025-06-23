package com.payment.processor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.payment.shared.events.PaymentEvent;

@Service
public class PaymentEventProducer {
    
    private static final String TOPIC = "payment-events";
    
    @Autowired
    private KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    
    public void sendPaymentEvent(PaymentEvent event) {
        kafkaTemplate.send(TOPIC, event.getTransactionId(), event);
    }
}
