package com.course.enroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.enroll.entity.EnrollCourse;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollCourse, Integer>{

	List<EnrollCourse> findByUserId(int id);

}
