package com.genpact.dao;

import java.util.List;

import com.genpact.pojo.Request;
import com.genpact.pojo.Student;

public interface StudentDAO {
	
	//checkStudent
	boolean checkStudent(Student student);
	
    //	Update Student profile
	boolean updateStudent(Student student);

	//add Student
	boolean addNewStudent(Student student);
	
	//view all students
	List<Student> getAllStudents();
	
    Student getStudentDetail(int studentID);
    
    //view request response by studentId
    List<Request> viewAllResponse(int studentID);    
    
}
