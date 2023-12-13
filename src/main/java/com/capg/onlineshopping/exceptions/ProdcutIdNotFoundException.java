package com.capg.onlineshopping.exceptions;

public class ProdcutIdNotFoundException extends RuntimeException {
	String msg;
	public ProdcutIdNotFoundException(String msg) {
		super(msg);
	}
	public String getMsg()
    {
    	return msg;
    }


}
