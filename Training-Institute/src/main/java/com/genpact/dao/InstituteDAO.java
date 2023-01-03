package com.genpact.dao;

import java.util.List;

import com.genpact.pojo.Feedback;
import com.genpact.pojo.Institute;
import com.genpact.pojo.Request;
import com.genpact.pojo.Student;


public interface InstituteDAO {

    //	Update institute profile
	boolean updateInstitute(Institute institute);
	
	//delete Institute
	boolean deleteInstitute(int instituteID);
	
	//add new Institute
	boolean addNewInstitute(Institute institute);
	
	//check Institute
	boolean checkInstitute(Institute institute);
	
	//get all Institutes
	List<Institute> getAllInstitutes();
	
	Institute getInstituteDetails(int instituteID);

	List<Request> getAllRequests(int instituteID);
	
	List<Student> getAllStudents(int instituteID);
	
	List<Feedback> getAllFeedbacks(int instituteID);
	
	boolean setStudentRequestStatus(Request studentRequest, int status);
	
	boolean isSeatAvailable(int instituteID);

    boolean incrementFilledSeatByOne(int instituteID);

    boolean requireAttention(Request studentRequest);
    
    boolean updateStudentWithInstitute(Request studentRequest);
	
	
}
