package com.capg.onlineshopping.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleEmail(IdNotFoundException idNotFoundException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(idNotFoundException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUser(UserNotFoundException userIdNotFoundException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(userIdNotFoundException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	
	}
	@ExceptionHandler(CategoryAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> handleUser(CategoryAlreadyExistsException alreadyExistsException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(alreadyExistsException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CategoryIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserId(CategoryIdNotFoundException categoryIdNotFoundException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(categoryIdNotFoundException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ProdcutIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUser(ProdcutIdNotFoundException prodcutIdNotFoundException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(prodcutIdNotFoundException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ErrorInfo> invalidEmail(InvalidEmailException invalidEmailException)
	{
		System.out.println("---inside global---");
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(invalidEmailException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorInfo> handleUser(InvalidPasswordException invalidPasswordException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(invalidPasswordException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExistSException.class)
	public ResponseEntity<ErrorInfo> userExits(UserAlreadyExistSException alreadyExistSException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(alreadyExistSException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsufficientProductQuantityException.class)
	public ResponseEntity<ErrorInfo> quantityExists(InsufficientProductQuantityException insufficientProductQuantityException)
	{
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorMessage(insufficientProductQuantityException.getMsg());
	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
	errorInfo.setLocalDateTime(LocalDateTime.now());
	return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	

}
