package com.learnersacademy.reportgenerator.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnersacademy.reportgenerator.entity.Classes;
import com.learnersacademy.reportgenerator.entity.Students;

@Component
public class DatabaseConnector {

	@Autowired
	private ClassesRepositery repositery;

	public String findClasses(String classId) throws Exception {
		Optional<Classes> c = repositery.findById(classId);
		if (c.isPresent()) {
			Classes cl = c.get();
			System.out.println("second entry" +cl.getClassName());
			return cl.getClassName();
			
		} else
			throw new Exception("Provided ClassID is not found");
	}

}
