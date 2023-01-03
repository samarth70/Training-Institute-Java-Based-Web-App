package com.genpact.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genpact.dao.RequestDAO;
import com.genpact.pojo.Course;
import com.genpact.pojo.Request;


@Controller
public class RequestController {
	
	private RequestDAO daoImpl;

	@Autowired
	public void setDaoImpl(RequestDAO daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	
	@RequestMapping(value = "/submitRequest" , method = RequestMethod.POST)
	public String register(Request request) {
		if(daoImpl.isAlreadyRequested(request)) {
		    return "alreadyRequested";
		}
		if(daoImpl.submitRequest(request))
			return "reqSentSuccess";
		else
			return "reqSentError";
	}
	
	@RequestMapping(value = "/submitRequestForm" , method = RequestMethod.GET)
	public String showRegisterPage(Model m, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    int studentID = Integer.parseInt(request.getParameter("studentID"));
	    session.setAttribute("studentID", studentID);
        session.setAttribute("instituteList", daoImpl.getAllInstitutes());
        Map<Integer, Course> courseMap = new HashMap<Integer, Course>();
        for (Course course : daoImpl.getAllCourses()) {
            courseMap.put(course.getInstituteID(), course);
        }
        session.setAttribute("instToCourseMap", courseMap);
		return "request-form";
	}

}
