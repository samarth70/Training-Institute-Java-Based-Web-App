package com.genpact.pojo;


public class Feedback 
{
	private int feedbackID;
	private int userID;
	private int instituteID;
	private String description;
	private String date;
	
	public Feedback() {
		super();
	}
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getInstituteID() {
		return instituteID;
	}
	public void setInstituteID(int instituteID) {
		this.instituteID = instituteID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}