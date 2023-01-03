package com.genpact.pojo;

import java.sql.Date;

public class Request {
	private int requestID;
	private int userID;
	private int courseID;
	private int instituteID;
	private String studentName;
	private Date requestDate;
	private int status;
	
	public Request() {
		super();
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public int getInstituteID() {
		return instituteID;
	}
	public void setInstituteID(int instituteID) {
		this.instituteID = instituteID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
		

}