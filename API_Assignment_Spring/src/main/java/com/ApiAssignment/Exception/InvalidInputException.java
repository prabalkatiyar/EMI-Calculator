package com.ApiAssignment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errorMessage)
	{
		super(errorMessage);
	}

}
