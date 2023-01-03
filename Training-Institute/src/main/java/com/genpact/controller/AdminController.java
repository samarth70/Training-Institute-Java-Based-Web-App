package com.genpact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.genpact.dao.AdminDAO;
import com.genpact.pojo.Admin;


@Controller
public class AdminController {

	private AdminDAO daoImpl;
	
	@Autowired
	public void setDaoImpl(AdminDAO daoImpl) {
		this.daoImpl = daoImpl;
	}

	
	@RequestMapping(value = "/acceptAdmin" , method = RequestMethod.POST)
	public ModelAndView loginUser(Admin admin, HttpServletRequest request) {
		
		HttpSession session = null;
		
		if(daoImpl.checkAdmin(admin)) {
			
			Admin ad = daoImpl.getAdminDetail(admin.getAdminID());
			
			session = request.getSession(true);
			session.setAttribute("adminID", ad.getAdminID());
			session.setAttribute("adminPassword", ad.getAdminPassword());
			
			ModelAndView mv = new ModelAndView("admin-home","ADMINOBJ",ad);
			return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView("admin-errorLogin","",null);
			return mv;
		}
	}
	
	
	@RequestMapping(value = "/logout" , method = RequestMethod.POST)
	public void logoutUser(HttpSession session)
	{
		session.setAttribute("ADMINOBJ", null);
		session.invalidate();
	}
	
	
}














