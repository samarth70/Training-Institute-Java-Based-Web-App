package com.genpact.dao;

import java.util.List;

import com.genpact.pojo.Feedback;

public interface FeedbackDAO {
	
	//add Feedback
	boolean addNewFeedback(Feedback feedback);
	
	//show all feedbacks
	List<Feedback> getAllFeedbacks();
	
	//show all feedbacks for institute
    Feedback getAllFeedbacksForInstitute(int instituteID);

}
