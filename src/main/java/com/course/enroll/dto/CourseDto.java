package com.course.enroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CourseDto {
	private int courseId;
	private String courseName;
	private String duration;
}
