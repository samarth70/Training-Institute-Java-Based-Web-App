package com.genpact.pojo;

public class Student {
	private int studentID;
	private String emailID; 	
	private String studentName;
	private int instituteID;
	private String qualification;
	private String studentPassword;
	private String number;
	private String address;
	
	public Student() {
		super();
	}



	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}



	public int getInstituteID() {
		return instituteID;
	}



	public void setInstituteID(int instituteID) {
		this.instituteID = instituteID;
	}



	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
