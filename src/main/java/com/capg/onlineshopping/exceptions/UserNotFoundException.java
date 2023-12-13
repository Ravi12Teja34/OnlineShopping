package com.capg.onlineshopping.exceptions;

public class UserNotFoundException extends RuntimeException {
	String msg;
	public UserNotFoundException(String msg)
	{
		super(msg);
	}
	public String getMsg()
    {
    	return msg;
    }

}
