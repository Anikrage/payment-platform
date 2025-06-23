package com.payment.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.processor.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
