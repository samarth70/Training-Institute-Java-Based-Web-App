package com.genpact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.genpact.dao.StudentDAO;
import com.genpact.pojo.Request;
import com.genpact.pojo.Student;


@Controller
public class StudentController {

	private StudentDAO daoImpl;
	
	@Autowired
	public void setDaoImpl(StudentDAO daoImpl) {
		this.daoImpl = daoImpl;
	}

	
	@RequestMapping(value = "/acceptStudent" , method = RequestMethod.POST)
	public ModelAndView loginUser(Student student, HttpServletRequest request) {
		
		HttpSession session = null;
		
		if(daoImpl.checkStudent(student)) {
			
			Student stud = daoImpl.getStudentDetail(student.getStudentID());
			
			session = request.getSession(true);
			session.setAttribute("studentID", stud.getStudentID());
			session.setAttribute("studentPassword", stud.getStudentPassword());
			
			ModelAndView mv = new ModelAndView("student-home","STUDOBJ",stud);
			return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView("student-errorLogin","",null);
			return mv;
		}
	}
	
	
	@RequestMapping(value = "/viewAStudent" , method = RequestMethod.GET)
	public String showStudentPage(HttpServletRequest request, Model theModel) {
		String studentName = request.getParameter("studentName");
		//int id = Integer.parseInt(request.getParameter("studentID"));
		theModel.addAttribute("studentName", studentName);
		//theModel.addAttribute("studentID", id);
		return "single-student";
	}
	
	
	
	@RequestMapping(value = "/updateStudentForm" , method = RequestMethod.GET)
	public String showUpdatePage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		session.setAttribute("studentID", studentID);
		
		return "update-student";
	}
	

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String update(Student student)
	{
		if(daoImpl.updateStudent(student))
			return "successUpdate";
		else
			return "errorUpdate";
	}
	
	
	@RequestMapping(value = "/registerStudentForm" , method = RequestMethod.GET)
	public String showRegisterPage() {
		
		return "student-register";
	}
	
	
	@RequestMapping(value = "/registerStudent" , method = RequestMethod.POST)
	public String register(Student student) {
		
		if(daoImpl.addNewStudent(student))
			return "studentSuccessRegister";
		else
			return "errorRegister";
	}
	
	@RequestMapping(value = "/logoutStudent" , method = RequestMethod.GET)
	public void logoutUser(HttpSession session)
	{
		session.setAttribute("STUDOBJ", null);
		session.invalidate();
	}

	@RequestMapping(value = "/viewstudents" , method = RequestMethod.GET)
	public String viewStudents(Model m) {
		
		List<Student> lst=daoImpl.getAllStudents();
		m.addAttribute("lst",lst);
		return "student-table";
	}
	
	@RequestMapping(value = "/viewresponses/{studentID}" , method = RequestMethod.GET)
	public String viewResponses(Model m, @PathVariable int studentID) {
		
		List<Request> lst= daoImpl.viewAllResponse(studentID);
		m.addAttribute("lst",lst);
		return "response-table";
	}
	
}














