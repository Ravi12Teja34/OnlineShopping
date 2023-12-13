package com.capg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.onlineshopping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
