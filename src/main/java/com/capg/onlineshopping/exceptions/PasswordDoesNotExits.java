package com.capg.onlineshopping.exceptions;

public class PasswordDoesNotExits extends RuntimeException{
	String msg;
	 public PasswordDoesNotExits(String msg)
	 {
		super(msg);
      }
	 public String getMsg()
	    {
	    	return msg;
	    }
}
