package com.amir35.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir35.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
