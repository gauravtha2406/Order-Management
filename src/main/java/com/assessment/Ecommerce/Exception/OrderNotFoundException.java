package com.assessment.Ecommerce.Exception;

public class OrderNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;




	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException(String message, Throwable e) {
		super(message,e);
	}

}
