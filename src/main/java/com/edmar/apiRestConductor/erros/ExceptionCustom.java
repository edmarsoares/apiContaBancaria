package com.edmar.apiRestConductor.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ExceptionCustom extends RuntimeException{

	public ExceptionCustom(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
