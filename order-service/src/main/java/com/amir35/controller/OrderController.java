package com.amir35.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir35.entity.Order;
import com.amir35.service.OrderService;
import com.amir35.transaction.Payment;
import com.amir35.transaction.TransactionRequest;
import com.amir35.transaction.TransactionResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
	{
		//System.out.println(order);
		return orderService.saveOrder(request);
	}

}
