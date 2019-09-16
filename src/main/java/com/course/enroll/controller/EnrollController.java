package com.course.enroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.enroll.dto.EnrollRequestDto;
import com.course.enroll.dto.EnrollResponseDto;
import com.course.enroll.dto.MyCourseListDto;
import com.course.enroll.service.EnrollService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class EnrollController {

	@Autowired
	EnrollService enrollService;
	
	@PostMapping("/enrollCourse")
	public ResponseEntity<EnrollResponseDto> enrollCourse(@RequestBody EnrollRequestDto enrollRequestDto) {
		log.info("enters into enrollCourse() controller for enroll a course");
		return new ResponseEntity<>(enrollService.enrollCourse(enrollRequestDto), HttpStatus.OK);
	}
	
	@GetMapping("/mycourses/{id}")
	public ResponseEntity<MyCourseListDto> viewMyCourse(@PathVariable int id){
		log.info("enters into viewMyCourse() controller for view list of user courses");
		return new ResponseEntity<>(enrollService.viewMyCourses(id),HttpStatus.OK);
	}

}
