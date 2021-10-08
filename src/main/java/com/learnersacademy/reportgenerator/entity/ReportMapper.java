package com.learnersacademy.reportgenerator.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReportMapper implements RowMapper<ReportGeneration> {

	@Override
	public ReportGeneration mapRow(ResultSet rs, int rowNum) throws SQLException {
		String studentName = rs.getString(1);
		String className = rs.getString(2);
		String subjectName = rs.getString(3);
		String subjectID = rs.getString(4);
		String teacherName = rs.getString(5);
		String teacherID = rs.getString(6);
		String studentID = rs.getString(7);
		String classID = rs.getString(8);
		ReportGeneration reportGeneration = new ReportGeneration();
		Classes classes = new Classes();
		classes.setClassID(classID);
		classes.setClassName(className);
		reportGeneration.setClasses(classes);
		
		Students students = new Students();
		students.setStudentID(studentID);
		students.setStudentName(studentName);
		reportGeneration.setStudent(students);
		
		Subjects subjects = new Subjects();
		subjects.setSujectID(subjectID);
		subjects.setSujectName(subjectName);
		reportGeneration.setSubjects(subjects);
		
		Teachers teachers = new Teachers();
		teachers.setTeacherID(teacherID);
		teachers.setTeacherName(teacherName);
		reportGeneration.setTeachers(teachers);
		
		return reportGeneration;
	}

}
