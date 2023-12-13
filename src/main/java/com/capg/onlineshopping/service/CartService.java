package com.capg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.entity.Cart;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.entity.User;
import com.capg.onlineshopping.repository.CartRepository;
import com.capg.onlineshopping.repository.ProductRepository;
import com.capg.onlineshopping.repository.UserRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		User user=   userRepository.findById(cart.getCustomer().getUserId()).get();
		List<Product> products = cart.getProducts();
		List<Product> prod = new ArrayList<>();
		for(Product product : products)
		{
			Product product2 = productRepository.findById(product.getProductId()).get();
			System.out.println("-----"+product2);
			prod.add(product2);
		}

		cart.setCustomer(user);
		cart.setProducts(prod);
		return cartRepository.save(cart);
	}	
//	public Cart removeCart(Cart cart)
//	{
//		//List<Product> products=productRepository.findById(cart.getProducts().)
//		return null;
//	}
	
	 public Cart removeProductFromCart(int cartId, int productId) {
	        Cart cart = cartRepository.findById(cartId).orElse(null);

	        if (cart != null) {
	            User user = userRepository.findById(cart.getCustomer().getUserId()).orElse(null);

	            if (user != null) {
	                List<Product> products = cart.getProducts();

	                // Remove the product with the specified productId from the cart
	                products.removeIf(product -> product.getProductId() == productId);

	                // Update the cart with the modified product list
	                cart.setProducts(products);
	                cart.setCustomer(user);

	                // Save the updated cart to the repository
	                cart = cartRepository.save(cart);
	            }
	        }

	        return cart;
	    }
	

}
