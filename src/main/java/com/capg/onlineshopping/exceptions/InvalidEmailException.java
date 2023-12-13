package com.capg.onlineshopping.exceptions;

public class InvalidEmailException extends RuntimeException{
	String msg;
	

	
	
	public InvalidEmailException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
