package com.pranesh.employee;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public void nullPointerException() {
		System.out.println("Null Pointer Exception Caught");
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public void runTimeException() {
		System.out.println("Runtime Exception Caught");
	}
	
}
