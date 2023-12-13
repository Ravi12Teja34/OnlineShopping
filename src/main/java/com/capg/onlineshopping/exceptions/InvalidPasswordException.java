package com.capg.onlineshopping.exceptions;

public class InvalidPasswordException extends RuntimeException{
	String msg;
	public InvalidPasswordException(String msg)
	{
		super(msg);
	}
	public String getMsg()
    {
    	return this.msg;
    }

}
