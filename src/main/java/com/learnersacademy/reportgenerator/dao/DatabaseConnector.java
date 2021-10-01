package com.learnersacademy.reportgenerator.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnersacademy.reportgenerator.entity.Students;

@Component
public class DatabaseConnector {

	@Autowired
	private StudentRepositery repositery;
	
	public String findStudent(String studentId) {
		Optional<Students> std = repositery.findById(studentId);
		return std.get().getStudentName();
	}

}
