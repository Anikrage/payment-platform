package com.payment.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
