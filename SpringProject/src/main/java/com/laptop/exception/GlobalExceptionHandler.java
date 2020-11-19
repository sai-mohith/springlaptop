package com.laptop.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList("Wrong method name","Not supported");
		APIErrors errors = new APIErrors(message, timestamp, status , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList("Wrong media type","irrelevant");
		APIErrors errors = new APIErrors(message, timestamp, status , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(status).body(errors);
		
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList("missing path variable","No variable");
		APIErrors errors = new APIErrors(message, timestamp, status , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList("No request param","missing param");
		APIErrors errors = new APIErrors(message, timestamp, status , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList("Mismatch of data types","Wrong type");
		APIErrors errors = new APIErrors(message, timestamp, status , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(status).body(errors);
	}
	@ExceptionHandler(LaptopNotFoundException.class)
	protected ResponseEntity<Object> handleLaptopException(LaptopNotFoundException ex){
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList("Laptop is not available");
		APIErrors errors = new APIErrors(message, timestamp, HttpStatus.BAD_REQUEST , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
		
	}
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> Exception(LaptopNotFoundException ex){
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		List<String> details=  Arrays.asList(message);
		APIErrors errors = new APIErrors(message, timestamp, HttpStatus.INTERNAL_SERVER_ERROR , details);
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
		
		
	}

	
}
