 package com.capg.onlineshopping.exceptions;

public class CategoryIdNotFoundException extends RuntimeException
{
	String msg;
     public  CategoryIdNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
    	 super(msg);
	}
     public String getMsg()
     {
     	return msg;
     }

     
}