package com.learnersacademy.reportgenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "subjects")
public class Subjects {
	@Id
	@Column (name = "SubjectID")
	private String SujectID;
	@Column (name = "SujectName")
	private String SujectName;
	public String getSujectID() {
		return SujectID;
	}
	public void setSujectID(String sujectID) {
		SujectID = sujectID;
	}
	public String getSujectName() {
		return SujectName;
	}
	public void setSujectName(String sujectName) {
		SujectName = sujectName;
	}
	

}
