package com.ty.springboot_hospital_app.service.exception;

public class DataNotFoundException extends RuntimeException
{
	private String message;

	public DataNotFoundException(String message) 
	{
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
