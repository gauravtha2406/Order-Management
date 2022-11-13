package com.assessment.Ecommerce.Exception;

public class OrderNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String msg;

	public OrderNotFoundException() {
		this.msg = "User not found";
	}

	public OrderNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "OrderNotFoundException " + msg;
	}

}
