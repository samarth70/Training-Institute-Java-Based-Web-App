package com.genpact.pojo;

public class Course {
	
	private int courseID;
	private String courseName;
	private int instituteID;
	
	public Course() {
		super();
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getInstituteID() {
		return instituteID;
	}

	public void setInstituteID(int instituteID) {
		this.instituteID = instituteID;
	}

}
