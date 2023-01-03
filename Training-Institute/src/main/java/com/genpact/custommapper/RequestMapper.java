package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.pojo.Request;

public class RequestMapper {
	
	public static Request mapRequest(ResultSet rs) throws SQLException
	{
		Request pr = new Request();
		
		pr.setRequestID(rs.getInt("requestID"));
		pr.setUserID(rs.getInt("userID"));
		pr.setStudentName(rs.getString("studentName"));
		pr.setCourseID(rs.getInt("courseID"));
		pr.setInstituteID(rs.getInt("instituteID"));
		pr.setRequestDate(rs.getDate("requestDate"));
		pr.setStatus(rs.getInt("status"));
		
		return pr;
	}


}
