package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.pojo.Student;

public class StudentRowMapper implements RowMapper<Student>{


	@Override
	public Student mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Student pr = new Student();
		
		pr.setStudentID(rs.getInt("studentID"));
		pr.setEmailID(rs.getString("emailID"));
		pr.setStudentName(rs.getString("studentName"));
		pr.setInstituteID(rs.getInt("instituteID"));
		pr.setQualification(rs.getString("qualification"));
		pr.setNumber(rs.getString("number"));
		pr.setAddress(rs.getString("address"));
		
		return pr;
	}
}
