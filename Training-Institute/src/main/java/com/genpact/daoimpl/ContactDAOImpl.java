package com.genpact.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import com.genpact.dao.ContactDAO;
import com.genpact.pojo.Contact;

@Service
public class ContactDAOImpl  implements ContactDAO{
	
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public boolean insertMessage(Contact contact) {
		boolean b = false;
		String query = "INSERT INTO contact values (?,?,?,?)";
		
		int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setString(1, contact.getName());
				ps.setString(2, contact.getEmail());
				ps.setString(3, contact.getSubject());
				ps.setString(4, contact.getMessage());
				
				return ps.executeUpdate();
			}
		});
		
		if(count > 0)
			b = true;
		
		return b;
	}
	
}
