package com.course.enroll.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoCourseEnrollException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(NoCourseEnrollException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(), exception.getMessage(),
				HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

}
