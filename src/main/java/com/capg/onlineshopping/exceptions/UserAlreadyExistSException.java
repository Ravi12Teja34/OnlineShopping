package com.capg.onlineshopping.exceptions;

public class UserAlreadyExistSException extends RuntimeException {
	String msg;
	
	public UserAlreadyExistSException(String msg)
	{
		super(msg);
	}
	 public String getMsg()
	    {
	    	return msg;
	    }

}
