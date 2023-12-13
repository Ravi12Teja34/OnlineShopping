package com.capg.onlineshopping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="CART")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@ManyToOne
	@JoinColumn(name="customer_id",referencedColumnName = "userId")
	private User Customer;
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="cart_id",referencedColumnName = "cartId"),inverseJoinColumns = @JoinColumn(name="product_id",referencedColumnName = "productId"))
	private List<Product> products;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getCustomer() {
		return Customer;
	}
	public void setCustomer(User customer) {
		Customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Cart()
	{
		products=new ArrayList<>();
	}

}
