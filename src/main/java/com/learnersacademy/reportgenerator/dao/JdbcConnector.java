package com.learnersacademy.reportgenerator.dao;

import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.learnersacademy.reportgenerator.entity.LoginMapper;
import com.learnersacademy.reportgenerator.entity.ReportGeneration;
import com.learnersacademy.reportgenerator.entity.ReportMapper;

@Component
public class JdbcConnector {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		JdbcConnector jdbcConnector = new JdbcConnector();
		jdbcConnector.loginCredentials("Admin", "Admin@123");
	}
	
	public boolean loginCredentials(String username, String password) {
		String query = "SELECT  employeename FROM users WHERE users.username='"+ username + "' AND users.password='" + password+"'";
		System.out.println(query);
		List<String> empNames =  jdbcTemplate.query(query, new LoginMapper());
		if(empNames.contains(username)) {
			return true; 	
		}
		return false;
	}
	
	public List<ReportGeneration> reportGeneration(String classID) {
		String query = "SELECT StudentName, classes.ClassName, subjects.SubjectName, subjects.SubjectID,  teachers.TeacherName, teachers.TeacherID, students.StudentID, classes.ClassID FROM students  \r\n"
				+ "INNER JOIN classes ON Students.ClassID=classes.ClassID \r\n"
				+ "INNER JOIN teacher_subject_class ON Students.ClassID=teacher_subject_class.ClassID \r\n"
				+ "RIGHT OUTER JOIN teachers on teacher_subject_class.TeacherID=teachers.TeacherID\r\n"
				+ "RIGHT OUTER JOIN subjects on teacher_subject_class.SubjectID=subjects.SubjectID\r\n"
				+ "WHERE classes.ClassID="+classID;
		
						
		List<ReportGeneration> reportList=jdbcTemplate.query(query, new ReportMapper());
		return reportList;
	}

}
