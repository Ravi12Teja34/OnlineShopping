package com.capg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.onlineshopping.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
