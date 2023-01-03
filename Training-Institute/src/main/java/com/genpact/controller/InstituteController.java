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

import com.genpact.dao.InstituteDAO;
import com.genpact.pojo.Feedback;
import com.genpact.pojo.Institute;
import com.genpact.pojo.Request;
import com.genpact.pojo.Student;


@Controller
public class InstituteController {
	
	private InstituteDAO daoImpl;

	@Autowired
	public void setDaoImpl(InstituteDAO daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	@RequestMapping(value = "/acceptInstitute" , method = RequestMethod.POST)
	public ModelAndView loginUser(Institute institute, HttpServletRequest request) {
		
		HttpSession session = null;
		
		if(daoImpl.checkInstitute(institute)) {
			
			Institute inst = daoImpl.getInstituteDetails(institute.getInstituteID());
			
			session = request.getSession(true);
			session.setAttribute("instituteID", inst.getInstituteID());
			session.setAttribute("instituteName", inst.getInstituteName());
			
			ModelAndView mv = new ModelAndView("institute-home","INSTOBJ",inst);
			return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView("institute-errorLogin","",null);
			return mv;
		}
	}
	
	@RequestMapping(value = "/updateInstituteForm" , method = RequestMethod.GET)
	public String showUpdatePage(  HttpServletRequest request) {
		
		    HttpSession session = request.getSession();

		    int instituteID = Integer.parseInt(request.getParameter("instituteID"));
		    session.setAttribute("instituteID",instituteID);
	       		    
		    return "update-institute";
	}
	

	@RequestMapping(value = "/updateInstitute", method = RequestMethod.GET)
	public String update(Institute institute)
	{
		if(daoImpl.updateInstitute(institute))
			return "successUpdate";
		else
			return "errorUpdate";
	}
	
	
	@RequestMapping(value = "/registerInstituteForm" , method = RequestMethod.GET)
	public String showRegisterPage() {
		
		return "institute-register";
	}
	
	
	@RequestMapping(value = "/registerInstitute" , method = RequestMethod.POST)
	public String register(Institute institute) {
		
		if(daoImpl.addNewInstitute(institute))
			return "instituteSuccessRegister";
		else
			return "errorRegister";
	}
	
	
	@RequestMapping(value = "/deleteInstituteForm" , method = RequestMethod.GET)
	public String showDeletePage() {
		
		return "delete-institute";
	}
	
	
	@RequestMapping(value = "/deleteInstitute" , method = RequestMethod.GET)
	public String delete(Institute institute) {
		
		if(daoImpl.deleteInstitute(institute.getInstituteID()))
			return "deleteInstSuccess";
		else
			return "deleteInstError";
	}
	
	@RequestMapping(value = "/viewinstitutes" , method = RequestMethod.GET)
	public String viewInstitutes(Model m) {
		
		List<Institute> lst=daoImpl.getAllInstitutes();
		m.addAttribute("lst",lst);
		return "institute-table";
	}
	
	@RequestMapping(value = "/viewstudentrequests/{instituteID}" , method = RequestMethod.GET)
	public String showStudentRequests(Model m, @PathVariable int instituteID) {
		
		List<Request> lst= daoImpl.getAllRequests(instituteID);
		m.addAttribute("lst",lst);
		return "request-table";
	}
	
	/*@RequestMapping(value = "/viewNewStudentRequests/{instituteID}" , method = RequestMethod.GET)
    public String viewNewStudentRequests(Model m, @PathVariable int instituteID) {
        
        List<Request> lst=daoImpl.getAllNewRequests(instituteID);
        m.addAttribute("studentNewRequestsList",lst);
        
        return "student-new-request-table";
    }*/

	
	@RequestMapping(value = "/viewInststudents/{instituteID}" , method = RequestMethod.GET)
	public String viewInstStudents(Model m, @PathVariable int instituteID) {
		
		List<Student> lst= daoImpl.getAllStudents(instituteID);
		m.addAttribute("lst",lst);
		return "inst-student-table";
	}
	
	@RequestMapping(value = "/viewInstfeedbacks/{instituteID}" , method = RequestMethod.GET)
	public String viewInstFeedbacks(Model m, @PathVariable int instituteID) {
		
		List<Feedback> lst= daoImpl.getAllFeedbacks(instituteID);
		m.addAttribute("lst",lst);
		return "inst-feedback-table";
	}
    
    @RequestMapping(value = "/approveStudentRequest", method = RequestMethod.GET)
    public String approveStudentRequest(Model m, HttpServletRequest request) {
        
    	int instituteID = Integer.parseInt(request.getParameter("instituteID"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        int courseID = Integer.parseInt(request.getParameter("courseID"));
        
        Request admissionRequest = new Request();
        admissionRequest.setInstituteID(instituteID);
        admissionRequest.setUserID(userID);
        admissionRequest.setCourseID(courseID);
        
        if(!daoImpl.isSeatAvailable(instituteID)) {
            return "seat-filled";
        }
        if(!daoImpl.requireAttention(admissionRequest)) {
            return "already-attended";
        }
        daoImpl.setStudentRequestStatus(admissionRequest, 1);
        daoImpl.incrementFilledSeatByOne(instituteID);
        daoImpl.updateStudentWithInstitute(admissionRequest);
        
        List<Request> lst= daoImpl.getAllRequests(instituteID);
        m.addAttribute("lst",lst);
        
        return "request-table";
    }
    
    @RequestMapping(value = "/rejectStudentRequest", method = RequestMethod.GET)
    public String rejectStudentRequest(Model m, HttpServletRequest request) {
        
    	int instituteID = Integer.parseInt(request.getParameter("instituteID"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        int courseID = Integer.parseInt(request.getParameter("courseID"));
        Request admissionRequest = new Request();
        admissionRequest.setInstituteID(instituteID);
        admissionRequest.setUserID(userID);
        admissionRequest.setCourseID(courseID);
        
        if(!daoImpl.requireAttention(admissionRequest)) {
            return "already-attended";
        }
        
        daoImpl.setStudentRequestStatus(admissionRequest, -1);
        
        List<Request> lst= daoImpl.getAllRequests(instituteID);
        m.addAttribute("lst",lst);
        
        return "request-table";
    }
   
}
