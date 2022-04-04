package com.amir35.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amir35.entity.Order;
import com.amir35.repository.OrderRepository;
import com.amir35.transaction.Payment;
import com.amir35.transaction.TransactionRequest;
import com.amir35.transaction.TransactionResponse;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request)
	{
		String message = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//rest api call to payment microservice
		Payment paymentResponse = template.postForObject("http://payment-service/payment/doPayment", payment, Payment.class);
		
		if(paymentResponse.getPaymentStatus().equals("success"))
		{
			message = "Payment processing successful and order placed";
		}else
		{
			message = "Order added to cart";
		}
		
		orderRepository.save(order);
		
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), message);
	}

}
