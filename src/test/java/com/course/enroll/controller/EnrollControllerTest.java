package com.course.enroll.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.course.enroll.dto.CourseIdDto;
import com.course.enroll.dto.EnrollRequestDto;
import com.course.enroll.dto.EnrollResponseDto;
import com.course.enroll.service.EnrollServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EnrollControllerTest {

	@Mock
	EnrollServiceImpl enrollServiceImpl;

	@InjectMocks
	EnrollController enrollController;

	@Test
	public void testEnrollCourse() {
		List<CourseIdDto> courseIdDTOList = new ArrayList<>();
		EnrollRequestDto enrollRequestDto = new EnrollRequestDto();
		enrollRequestDto.setUserId(1);
		enrollRequestDto.setCourseIdDto(courseIdDTOList);
		EnrollResponseDto enrollResponseDTO = new EnrollResponseDto();
		enrollResponseDTO.setStatusCode(HttpStatus.OK.value());
		Mockito.when(enrollServiceImpl.enrollCourse(enrollRequestDto)).thenReturn(enrollResponseDTO);
		ResponseEntity<EnrollResponseDto> actualValue = enrollController.enrollCourse(enrollRequestDto);
		assertEquals(enrollResponseDTO.getStatusCode(), actualValue.getBody().getStatusCode());

	}



}
