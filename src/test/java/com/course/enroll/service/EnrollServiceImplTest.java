package com.course.enroll.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.course.enroll.dto.CourseDto;
import com.course.enroll.dto.CourseIdDto;
import com.course.enroll.dto.EnrollRequestDto;
import com.course.enroll.dto.EnrollResponseDto;
import com.course.enroll.entity.EnrollCourse;
import com.course.enroll.repository.EnrollRepository;

@RunWith(MockitoJUnitRunner.class)
public class EnrollServiceImplTest {

	@Mock
	EnrollRepository enrollRepository;

	@InjectMocks
	EnrollServiceImpl enrollServiceImpl;

	@Test
	public void testEnrollCourse() {
		List<CourseIdDto> courseIdDtoList = new ArrayList<>();
		CourseIdDto courseDto = new CourseIdDto();
		courseDto.setCourseId(1);
		courseIdDtoList.add(courseDto);
		CourseIdDto courseDto1 = new CourseIdDto();
		courseDto1.setCourseId(1);
		courseIdDtoList.add(courseDto1);
		EnrollRequestDto courseEnrollmentDTO = new EnrollRequestDto();
		courseEnrollmentDTO.setUserId(1);
		courseEnrollmentDTO.setCourseIdDto(courseIdDtoList);
		List<EnrollCourse> enrollCoursesList = new ArrayList<>();
		EnrollCourse enrollCourse = new EnrollCourse();
		enrollCourse.setUserId(1);
		enrollCourse.setCourseId(1);
		enrollCourse.setEnrollDate(LocalDate.now());
		enrollCoursesList.add(enrollCourse);
		EnrollCourse enrollCourse1 = new EnrollCourse();
		enrollCourse1.setUserId(1);
		enrollCourse1.setCourseId(2);
		enrollCourse1.setEnrollDate(LocalDate.now());
		enrollCoursesList.add(enrollCourse1);
		Mockito.when(enrollRepository.saveAll(Mockito.any())).thenReturn(enrollCoursesList);
		EnrollResponseDto responseDTO = new EnrollResponseDto();
		responseDTO.setStatusCode(HttpStatus.OK.value());
		EnrollResponseDto actualValue = enrollServiceImpl.enrollCourse(courseEnrollmentDTO);
		assertEquals(responseDTO.getStatusCode(), actualValue.getStatusCode());
	}

	

}
