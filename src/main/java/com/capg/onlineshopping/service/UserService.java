package com.capg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.entity.User;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.exceptions.InvalidEmailException;
import com.capg.onlineshopping.exceptions.InvalidPasswordException;
import com.capg.onlineshopping.exceptions.UserAlreadyExistSException;
import com.capg.onlineshopping.exceptions.UserNotFoundException;
import com.capg.onlineshopping.repository.UserRepository;
import com.capg.onlineshopping.utility.AppConstant;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public User addUser(User user)throws   UserAlreadyExistSException, InvalidEmailException,InvalidPasswordException
	{
		
      User local=this.userRepository.findByEmail(user.getEmail());
		
      System.out.println(local);
		if(local!=null)
		{
			throw new UserAlreadyExistSException("User already present");
		}
		else {
			
		if(!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
		{
			throw new InvalidEmailException("EMAIL_CANNOT_BE_NULL");
		}
		if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) 
		{
			throw new InvalidPasswordException("INVALID_PASSWORD");
		}
		
		}
		return userRepository.save(user);
	}


	public List<User> fetchUsers() {
		return userRepository.findAll();
	}


	  public User updateUserDetail(int id, User user) 
	{
		if(userRepository.existsById(id))
		{
			user.setUserId(id);
		}
		else
		{
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
		
		return userRepository.save(user);
	}
	
	public User updateUserDetailAddress(int id, String address) 
	{

		if(userRepository.existsById(id))
		{
			User user=userRepository.findById(id).get();
			user.setAddress(address);
			return userRepository.save(user);
		}
		else
		{
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
		
	}
	
    public String deleteUserById(int id)
    {
    	String msg=" ";
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            msg="User id deleted succesfully"+id;
        } else 
        {
            throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
        }
        return msg;
    }


	public User checkUserLogin(User user) throws UserNotFoundException{
		//public User checkLogin(User user) throws UserNotFoundException
		
//			return userRepository.findByUserNameAndPassword(, password);
			User dbUser = userRepository.findByEmail(user.getEmail());
			if(dbUser.getPassword().equals(user.getPassword()))
				return dbUser;
			else 
			throw new UserNotFoundException(AppConstant.User_Not_Found_INFO);
		}
	
	public String userLogin(String email, String password) throws InvalidEmailException, InvalidPasswordException {

	        User user = userRepository.findByEmail(email);
	        System.out.println(user);

	       // System.out.println(user);

	        if (user != null && user.getPassword().equals(password)) {
	        	System.out.println("---if");

	            return "Login Successfulyy";

	        } else if(user == null) {
	        	System.out.println("----else if");

	        	throw new InvalidEmailException(AppConstant.INVALID_EMAIL_FOUND_INFO);

	        }else{
	        	System.out.println("----else");

	            throw new InvalidPasswordException(AppConstant.INVALID_PASSWORD_FOUND_INFO);

	        }
	}
}




