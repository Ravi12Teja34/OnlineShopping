package com.capg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.entity.Cart;
import com.capg.onlineshopping.entity.Order;
import com.capg.onlineshopping.entity.User;
//import com.capg.onlineshopping.exceptions.EmailIdDoesNotExit;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.exceptions.InsufficientProductQuantityException;
import com.capg.onlineshopping.exceptions.InvalidEmailException;
import com.capg.onlineshopping.exceptions.InvalidPasswordException;
import com.capg.onlineshopping.exceptions.PasswordDoesNotExits;
import com.capg.onlineshopping.exceptions.UserAlreadyExistSException;
import com.capg.onlineshopping.service.CartService;
import com.capg.onlineshopping.service.OrderService;
import com.capg.onlineshopping.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> addUser(@RequestBody User user)throws UserAlreadyExistSException,InvalidPasswordException,InvalidEmailException
	{
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User loginRequest)throws InvalidEmailException, InvalidPasswordException {
		    System.out.println(loginRequest.getEmail());
		
		return new ResponseEntity<String>(userService.userLogin(loginRequest.getEmail(), loginRequest.getPassword()),HttpStatus.OK);
	}
//	@PostMapping("/login")
//	public ResponseEntity<User> checkUserLoginDetails(@RequestBody User user) throws EmailIdDoesNotExit, PasswordDoesNotExits 
//	{
//		return new ResponseEntity<User>(userService.checkUserLogin(user),HttpStatus.OK);
//	}
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<>(userService.fetchUsers(),HttpStatus.OK);
	}
	
	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUserDetail(id,user),HttpStatus.OK);
	}
	
	@PutMapping("/updateaddress2/{id}")
	public ResponseEntity<User> updateUserAddress(@PathVariable int id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUserDetailAddress(id,user.getAddress()),HttpStatus.OK);
	}
	
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteUserById(@PathVariable int id)
	 {
		 return new ResponseEntity<String>(userService.deleteUserById(id),HttpStatus.OK);
	       
	    }
	 @PostMapping("/addcart")
		public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
		{
			return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.OK);
		}
	    @PostMapping("/placingorder")
		public ResponseEntity<Order> palcesOrder(@RequestBody Order orders) throws InsufficientProductQuantityException
		{
			return new ResponseEntity<Order>(orderService.placeOrder(orders),HttpStatus.OK);
		}	
	 
	 
	    @RequestMapping(value = "/remove-product/{cartId}/{productId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Cart> removeProductFromCart(@PathVariable int cartId, @PathVariable int productId) {
	        Cart updatedCart = cartService.removeProductFromCart(cartId, productId);
	        if (updatedCart != null) {
	            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	
}
