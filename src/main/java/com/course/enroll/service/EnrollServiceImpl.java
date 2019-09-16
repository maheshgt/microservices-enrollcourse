package com.course.enroll.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.course.enroll.dto.CourseDto;
import com.course.enroll.dto.CourseIdDto;
import com.course.enroll.dto.EnrollRequestDto;
import com.course.enroll.dto.EnrollResponseDto;
import com.course.enroll.dto.MyCourseDto;
import com.course.enroll.dto.MyCourseListDto;
import com.course.enroll.entity.EnrollCourse;
import com.course.enroll.exception.NoCourseEnrollException;
import com.course.enroll.repository.EnrollRepository;
import com.course.enroll.util.EnrollUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	EnrollRepository enrollRepository;

	@Autowired
	RestTemplate restTemplate;

	/**
	 * 
	 * 
	 */
	@Override
	public EnrollResponseDto enrollCourse(EnrollRequestDto enrollRequestDto) {
		log.info("enters into enrollCourse() service for enroll a course");
		Integer userId = enrollRequestDto.getUserId();
		List<CourseIdDto> courses = enrollRequestDto.getCourseIdDto();
		List<EnrollCourse> enrollCurseList = new ArrayList<>();
		courses.stream().forEach(course -> {
			EnrollCourse enrollCourse = new EnrollCourse();
			enrollCourse.setCourseId(course.getCourseId());
			enrollCourse.setUserId(userId);
			enrollCourse.setEnrollDate(LocalDate.now());
			enrollCurseList.add(enrollCourse);
		});
		List<EnrollCourse> list = enrollRepository.saveAll(enrollCurseList);
		if (list.isEmpty())
			throw new NoCourseEnrollException(EnrollUtil.ENROLL_COURSE_FAILURE);
		EnrollResponseDto enrollResponceDto = new EnrollResponseDto();
		enrollResponceDto.setMessage(EnrollUtil.ENROLL_COURSE);
		enrollResponceDto.setStatusCode(HttpStatus.OK.value());
		return enrollResponceDto;
	}

	@Override
	public MyCourseListDto viewMyCourses(int id) {

		log.info("enters into viewMyCourse() service for getting user course list");

		List<EnrollCourse> enrollList = enrollRepository.findByUserId(id);
		String url = EnrollUtil.URL;
		MyCourseListDto myCourseListDto = new MyCourseListDto();
		List<MyCourseDto> myCourseList = new ArrayList<>();
		if (enrollList.isEmpty())
			throw new NoCourseEnrollException(EnrollUtil.NO_COURSE);
		enrollList.stream().forEach(list -> {
			CourseDto course = restTemplate.getForObject(url, CourseDto.class, list.getCourseId());
			MyCourseDto myCoursesDto = new MyCourseDto();
			myCoursesDto.setCourseName(course.getCourseName());
			myCoursesDto.setDuration(course.getDuration());
			myCoursesDto.setEnrollDate(list.getEnrollDate());
			myCourseList.add(myCoursesDto);
		});
		myCourseListDto.setMyCourseDto(myCourseList);
		myCourseListDto.setStatusCode(HttpStatus.OK.value());
		return myCourseListDto;
	}

}
