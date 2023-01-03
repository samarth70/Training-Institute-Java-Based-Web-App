package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.pojo.Feedback;


public class FeedbackRowMapper implements RowMapper<Feedback>{

	@Override
	public Feedback mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Feedback pr = new Feedback();
		
		pr.setFeedbackID(rs.getInt("feedbackID"));
		pr.setUserID(rs.getInt("userID"));
		pr.setInstituteID(rs.getInt("instituteID"));
		pr.setDate(rs.getString("feedbackDate"));
		pr.setDescription(rs.getString("description"));
				
		return pr;
	}
}
