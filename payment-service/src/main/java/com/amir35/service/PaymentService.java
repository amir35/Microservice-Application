package com.amir35.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir35.entity.Payment;
import com.amir35.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		
		System.out.println(payment);
		return paymentRepository.save(payment);
	}
	
	public String paymentProcessing()
	{
		//api should be 3rd party payment gateway (Paypal,paytm...)
		return new Random().nextBoolean() ? "success" : "False";
	}

}
