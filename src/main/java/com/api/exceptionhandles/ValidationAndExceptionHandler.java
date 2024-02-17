package com.api.exceptionhandles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.exception.DoctorNotFoundException;
import com.api.exception.PatientNotFoundException;

@RestControllerAdvice
public class ValidationAndExceptionHandler extends ResponseEntityExceptionHandler
{

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		System.out.println("Validation handler called.....");
	    BindingResult br=ex.getBindingResult();
	    List<ObjectError> list=br.getAllErrors();
	    List<String> errors=new ArrayList<>();
	    for(ObjectError or:list)
	    {
	    	errors.add(or.getDefaultMessage());
	    }
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	
	}
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Object> handleDoctorNotFoundEXception(DoctorNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
   
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handlePatientNotFoundEXception(PatientNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
   
}
