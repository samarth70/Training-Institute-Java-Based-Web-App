package com.genpact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genpact.daoimpl.ContactDAOImpl;
import com.genpact.pojo.Contact;


@Controller
public class ContactController {
	
	private ContactDAOImpl daoImpl;

	@Autowired
	public void setDaoImpl(ContactDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	
	@RequestMapping(value = "/insertmessage" , method = RequestMethod.POST)
	public String insertMessage(Contact contact) {
		
		if(daoImpl.insertMessage(contact))
			return "contact";
		else
			return "";
	}
	

}





