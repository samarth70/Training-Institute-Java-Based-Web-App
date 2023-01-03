package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.pojo.Feedback;



public class FeedbackMapper {
	
	
	public static Feedback mapFeedback(ResultSet rs) throws SQLException
	{
		
		Feedback pr = new Feedback();
		
		pr.setFeedbackID(rs.getInt("feedbackID"));
		pr.setUserID(rs.getInt("userID"));
		pr.setInstituteID(rs.getInt("instituteID"));
		pr.setDate(rs.getString("feedbackDate"));
		pr.setDescription(rs.getString("description"));
				
		return pr;
	}
}
