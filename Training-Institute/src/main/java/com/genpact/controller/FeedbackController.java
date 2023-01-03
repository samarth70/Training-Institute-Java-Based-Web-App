package com.genpact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genpact.dao.FeedbackDAO;
import com.genpact.pojo.Feedback;


@Controller
public class FeedbackController {
	
	private FeedbackDAO daoImpl;

	@Autowired
	public void setDaoImpl(FeedbackDAO daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	
	@RequestMapping(value = "/submitFeedbackPage" , method = RequestMethod.GET)
	public String showRegisterPage() {
		
		return "feedback-form";
	}
	
	
	@RequestMapping(value = "/submitFeedback" , method = RequestMethod.POST)
	public String register(Feedback feedback) {
		
		if(daoImpl.addNewFeedback(feedback))
			return "feedbackSuccess";
		else
			return "feedbackError";
	}
	
	@RequestMapping(value = "/showfeedbacks" , method = RequestMethod.GET)
	public String showFeedbacks(Model m) {
		
		List<Feedback> lst=daoImpl.getAllFeedbacks();
		m.addAttribute("lst",lst);
		return "feedback-table";
	}

}

