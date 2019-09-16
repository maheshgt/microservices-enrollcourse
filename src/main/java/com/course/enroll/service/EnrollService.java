package com.course.enroll.service;

import org.springframework.stereotype.Service;

import com.course.enroll.dto.EnrollRequestDto;
import com.course.enroll.dto.EnrollResponseDto;
import com.course.enroll.dto.MyCourseListDto;

@Service
public interface EnrollService {

	EnrollResponseDto enrollCourse(EnrollRequestDto enrollRequestDto);

	MyCourseListDto viewMyCourses(int id);
	
	
}
