package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.pojo.Faculty;



public class FacultyRowMapper implements RowMapper<Faculty>{

	@Override
	public Faculty mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Faculty faculty = new Faculty();
		faculty.setFacultyID(rs.getInt("facultyID"));
		faculty.setFacultyName(rs.getString("facultyName"));
		faculty.setInstituteID(rs.getInt("instituteID"));
		
		return faculty;
	}
}
