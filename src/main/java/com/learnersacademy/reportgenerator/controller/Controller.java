package com.learnersacademy.reportgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learnersacademy.reportgenerator.dao.DatabaseConnector;
import com.learnersacademy.reportgenerator.dao.JdbcConnector;
import com.learnersacademy.reportgenerator.entity.ReportGeneration;

@RestController
public class Controller {
	@Autowired
	private DatabaseConnector connector;
	
	@Autowired
	private JdbcConnector jdbcConnector;

	@GetMapping("/classes/{id}")
	public ResponseEntity<List<ReportGeneration>> getStudentNamefromID(@PathVariable(value ="id") String classId) {
		System.out.println("first entry "+classId);
		try {
		;
			return new ResponseEntity<>(jdbcConnector.reportGeneration(classId), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";

	}

}
