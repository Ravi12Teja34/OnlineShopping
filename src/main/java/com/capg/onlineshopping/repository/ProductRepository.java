package com.capg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.onlineshopping.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
