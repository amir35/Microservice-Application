package com.amir35.transaction;

import com.amir35.entity.Order;

public class TransactionRequest {
	
	private Order order;
	private Payment payment;
	
	
	
	public TransactionRequest() {
		super();
	}

	public TransactionRequest(Order order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	

}
