package com.capg.onlineshopping.exceptions;

public class IdNotFoundException extends RuntimeException {
	String msg;
	public IdNotFoundException(String msg)
	{
		super(msg);
	}
    public String getMsg()
    {
    	return this.msg;
    }
}
