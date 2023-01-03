package com.genpact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genpact.dao.FacultyDAO;
import com.genpact.pojo.Faculty;

@Controller
public class FacultyController {
	
	private FacultyDAO daoImpl;

	@Autowired
	public void setDaoImpl(FacultyDAO daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	
	@RequestMapping(value = "/registerFacultyForm" , method = RequestMethod.GET)
	public String showRegisterPage() {
		
		return "addFaculty";
	}
	
	
	@RequestMapping(value = "/registerFaculty" , method = RequestMethod.POST)
	public String register(Faculty faculty) {
		
		if(daoImpl.addNewFaculty(faculty))
			return "addSuccess";
		else
			return "addError";
	}	
	
	
	@RequestMapping(value = "/delFacultyForm" , method = RequestMethod.GET)
	public String delFacultyPage() {
		
		return "delete-faculty";
	}
	
	
	@RequestMapping(value = "/delteFaculty" , method = RequestMethod.POST)
	public String delte(int facultyID) {
		
		if(daoImpl.deleteFaculty(facultyID))
			return "deleteInstSuccess";
		else
			return "deleteInstError";
	}	
	
	
	@RequestMapping(value = "/showfaculties" , method = RequestMethod.GET)
	public String showFaculties(Model m) {
		
		List<Faculty> lst=daoImpl.getAllFaculties();
		m.addAttribute("lst",lst);
		return "faculty-table";
	}

}
