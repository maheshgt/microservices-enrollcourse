package com.course.enroll.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Enroll")
@NoArgsConstructor
@AllArgsConstructor
public class EnrollCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrollId;

	private int userId;
	private int courseId;
	private LocalDate enrollDate;

}
