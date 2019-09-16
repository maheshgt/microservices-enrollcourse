package com.course.enroll.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NoCourseEnrollException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final String message;
}
