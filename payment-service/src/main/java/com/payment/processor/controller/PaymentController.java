package com.payment.processor.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.processor.model.Payment;
import com.payment.processor.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/initiate")
    public ResponseEntity<Map<String, String>> initiatePayment(@RequestBody Map<String, Object> paymentRequest) {
        try {
            String paymentMethod = (String) paymentRequest.get("paymentMethod");
            String userId = (String) paymentRequest.get("userId");
            BigDecimal amount = new BigDecimal(paymentRequest.get("amount").toString());

            Payment payment = new Payment();
            payment.setPaymentMethod(paymentMethod);
            payment.setUserId(userId);
            payment.setAmount(amount);
            payment.setStatus("SUCCESS");
            payment.setTimestamp(LocalDateTime.now());

            Payment savedPayment = paymentRepository.save(payment);

            return ResponseEntity.ok(Map.of(
                "status", "SUCCESS",
                "message", paymentMethod + " payment processed",
                "transactionId", savedPayment.getId().toString()
            ));
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
