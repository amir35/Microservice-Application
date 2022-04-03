package com.amir35.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir35.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
