package com.learnersacademy.reportgenerator.entity;


public class Classes {

	private String classID;
	private String className;
	
	public Classes() {
		
	}
	
	public Classes(String classID, String className) {
		super();
		this.classID = classID;
		this.className = className;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	

}
