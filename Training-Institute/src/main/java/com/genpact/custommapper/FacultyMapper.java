package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.pojo.Faculty;


public class FacultyMapper {
	
	
	public static Faculty mapFaculty(ResultSet rs) throws SQLException
	{
		
		Faculty faculty = new Faculty();
		faculty.setFacultyID(rs.getInt("facultyID"));
		faculty.setFacultyName(rs.getString("facultyName"));
		faculty.setInstituteID(rs.getInt("instituteID"));
		
		return faculty;
	}
}
