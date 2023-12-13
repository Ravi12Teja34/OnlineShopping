package com.capg.onlineshopping.exceptions;

public class InsufficientProductQuantityException extends Exception {
	String msg;
	public InsufficientProductQuantityException(String msg)
	{
		super(msg);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
