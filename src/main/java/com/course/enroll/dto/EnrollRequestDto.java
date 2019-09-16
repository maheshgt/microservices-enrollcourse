package com.course.enroll.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollRequestDto {
	
	private int userId;
	private List<CourseIdDto> courseIdDto;
}
