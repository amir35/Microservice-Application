package com.amir35.transaction;

import com.amir35.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
	
	private Order order;
	private Payment payment;
	

}
