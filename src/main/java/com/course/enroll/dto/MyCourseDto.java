package com.course.enroll.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyCourseDto {
	
	private String courseName;
	private String duration;
	private LocalDate enrollDate;
	private int statusCode;
}
