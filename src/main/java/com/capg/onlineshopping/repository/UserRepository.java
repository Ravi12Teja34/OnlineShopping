package com.capg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.onlineshopping.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserNameAndPassword(String username,String password);

		User findByUserName(String username);

		User findByEmail(String email);

}
