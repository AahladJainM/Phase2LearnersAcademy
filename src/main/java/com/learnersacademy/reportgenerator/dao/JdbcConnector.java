package com.learnersacademy.reportgenerator.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.learnersacademy.reportgenerator.entity.Classes;
import com.learnersacademy.reportgenerator.entity.Report;
import com.learnersacademy.reportgenerator.entity.ReportMapper;
import com.learnersacademy.reportgenerator.entity.User;

@Component
public class JdbcConnector {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Classes> getAllClasses(){
		String query = "SELECT * FROM classes";
		List<Classes> classes =  jdbcTemplate.query(query, (rs, i) -> new Classes(rs.getString(1), rs.getString(2)));
		return classes;
	}
	
	public boolean loginCredentials(User user) {
		String query = "SELECT  employeename FROM users WHERE users.username='"+ user.getUsername() + "' AND users.password='" + user.getPassword()+"'";
		List<String> empNames =  jdbcTemplate.query(query, (rs, i) -> rs.getString(1));
		if(!empNames.isEmpty()) {
			return true; 	
		}
		return false;
	}
	
	public List<Report> reportGeneration(String classID) {
		String query = "SELECT StudentName, classes.ClassName, subjects.SubjectName, subjects.SubjectID,  teachers.TeacherName, teachers.TeacherID, students.StudentID, classes.ClassID FROM students  \r\n"
				+ "INNER JOIN classes ON Students.ClassID=classes.ClassID \r\n"
				+ "INNER JOIN teacher_subject_class ON Students.ClassID=teacher_subject_class.ClassID \r\n"
				+ "RIGHT OUTER JOIN teachers on teacher_subject_class.TeacherID=teachers.TeacherID\r\n"
				+ "RIGHT OUTER JOIN subjects on teacher_subject_class.SubjectID=subjects.SubjectID\r\n"
				+ "WHERE classes.ClassID="+classID;
						
		List<Report> reportList=jdbcTemplate.query(query, new ReportMapper());
		return reportList;
	}

}
