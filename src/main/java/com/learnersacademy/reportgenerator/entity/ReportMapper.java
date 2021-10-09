package com.learnersacademy.reportgenerator.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReportMapper implements RowMapper<Report> {

	@Override
	public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
		String studentName = rs.getString(1);
		String subjectName = rs.getString(3);
		String teacherName = rs.getString(5);
		
		Report report = new Report();
		report.setStudentName(studentName);
		report.setSubjectName(subjectName);
		report.setTeacherName(teacherName);
		
		return report;
	}

}
