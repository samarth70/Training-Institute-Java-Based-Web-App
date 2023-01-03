package com.genpact.pojo;

import java.sql.Date;

public class Institute {
	private int instituteID;
	private String instituteName;
	private String institutePassword;
	private String address;
	private int seats;
	private int filledSeats;
	private Date affiliationDate;

	public Institute() {
		super();
	}

	public int getInstituteID() {
		return instituteID;
	}

	public void setInstituteID(int instituteID) {
		this.instituteID = instituteID;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstitutePassword() {
		return institutePassword;
	}

	public void setInstitutePassword(String institutePassword) {
		this.institutePassword = institutePassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	
	public int getFilledSeats() {
		return filledSeats;
	}

	public void setFilledSeats(int filledSeats) {
		this.filledSeats = filledSeats;
	}

	public Date getAffiliationDate() {
		return affiliationDate;
	}

	public void setAffiliationDate(Date affiliationDate) {
		this.affiliationDate = affiliationDate;
	}
	
	

	
}
