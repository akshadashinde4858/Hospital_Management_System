package com.ty.springboot_hospital_app.service.exception;

public class EmailNotFoundException extends RuntimeException 
{
	private String message;

	public EmailNotFoundException(String message) 
	{
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
