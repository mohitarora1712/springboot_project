package com.lpu.emp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, String>> handleArithmeticEx(ArithmeticException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String> map = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->map.put(error.getField(), error.getDefaultMessage()));
		return map;
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleAllException(Exception ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return map;
	}

}
