package com.capg.onlineshopping.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.entity.Cart;
import com.capg.onlineshopping.entity.Order;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.entity.User;
import com.capg.onlineshopping.exceptions.InsufficientProductQuantityException;
import com.capg.onlineshopping.repository.CartRepository;
import com.capg.onlineshopping.repository.OrderRepository;
import com.capg.onlineshopping.repository.ProductRepository;
import com.capg.onlineshopping.repository.UserRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepositorys;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Order placeOrder(Order order) throws InsufficientProductQuantityException {
	
//			User user = userRepository.findById(order.getCustomer().getUserId()).get();
//			Cart cart = cartRepository.findById(order.getCart().getCartId()).get();
//			order.setOrderStatus(Order.OrderStatus.COMPLETED);
//			order.setOrderDate(LocalDateTime.now());
//			order.setCustomer(user);
//			order.setCart(cart);
//			return orderRepositorys.save(order);
		
        User user = userRepository.findById(order.getCustomer().getUserId()).orElse(null);
        Cart cart = cartRepository.findById(order.getCart().getCartId()).orElse(null);

        if (user != null && cart != null) {
            order.setOrderStatus(Order.OrderStatus.COMPLETED);
            order.setOrderDate(LocalDateTime.now());
            order.setCustomer(user);
            order.setCart(cart);

            // Update product quantities based on the order
           // updateProductQuantities(cart.getProducts());
            
               List<Product> products =   cart.getProducts();
              
               for(Product product :products)
               {
            	   
            	 Product prod=   productRepository.findById(product.getProductId()).get();
            	 System.out.println("-----"+prod.getQuantity());
            	 int quantity = prod.getQuantity()-1;
            	 System.out.println(quantity);
            	 prod.setQuantity(quantity);  
            	 productRepository.save(prod);
               }

            // Save the order
            return orderRepositorys.save(order);
        }

        return null; // Handle this case according to your application's needs
    }

//    private void updateProductQuantities(List<Product> products) throws InsufficientProductQuantityException {
//        for (Product product : products) {
//            int orderedQuantity = product.getQuantity();
//
//            // Update the product quantity in the ProductService
//            productService.updateProductQuantity(product.getProductId(), orderedQuantity);
//        }
//    }
//		
		
}
	


