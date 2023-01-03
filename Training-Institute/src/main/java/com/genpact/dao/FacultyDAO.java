package com.genpact.dao;

import java.util.List;

import com.genpact.pojo.Faculty;

public interface FacultyDAO {
	
	//add Faculty
	boolean addNewFaculty(Faculty faculty);
	
	//del faculty
	boolean deleteFaculty(int facultyID);
	
	//show all faculties
	List<Faculty> getAllFaculties();
	
	//show all faculties by Institute
    Faculty getAllFacultiesByInstitute(int instituteID);

}
