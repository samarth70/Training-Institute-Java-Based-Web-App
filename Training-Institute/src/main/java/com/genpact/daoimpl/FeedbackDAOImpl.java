package com.genpact.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import com.genpact.custommapper.FeedbackMapper;
import com.genpact.custommapper.FeedbackRowMapper;
import com.genpact.dao.FeedbackDAO;
import com.genpact.pojo.Feedback;

@Service
public class FeedbackDAOImpl implements FeedbackDAO{

	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addNewFeedback(Feedback feedback) {
		boolean b = false;
		String query = "INSERT INTO feedback(userID,instituteID,description,feedbackDate) values (?,?,?,?)";
		
		int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setInt(1, feedback.getUserID());
				ps.setInt(2, feedback.getInstituteID());
				ps.setString(3, feedback.getDescription());
				ps.setString(4, feedback.getDate());
				
				return ps.executeUpdate();
			}
		});
		
		if(count > 0)
			b = true;
		
		return b;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		
		List<Feedback> lst = new ArrayList<>();
		
		String query = "SELECT * FROM feedback";
		
		try {
		
		lst = jdbcTemplate.query(query, new FeedbackRowMapper());
		
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
		
		return lst;
	}
	

	@Override
	public Feedback getAllFeedbacksForInstitute(int instituteID) {
		
		Feedback feedback = null;
		
		String query = "SELECT * FROM feedback WHERE instituteID = ?";
		
		try {
			
			feedback = jdbcTemplate.execute(query, new PreparedStatementCallback<Feedback>() {


				@Override
				public Feedback doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					ps.setInt(1, instituteID);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.isBeforeFirst())
					{
						rs.next();
						Feedback fbk = FeedbackMapper.mapFeedback(rs);
						return fbk;
					}
					else
						return null;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return feedback;
		
	}
	

}
