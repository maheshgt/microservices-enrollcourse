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
public class MyCourseListDto {
	
	private List<MyCourseDto> myCourseDto;
	private int statusCode;
}
