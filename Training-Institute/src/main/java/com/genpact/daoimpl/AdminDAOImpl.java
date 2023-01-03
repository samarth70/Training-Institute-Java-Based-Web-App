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

import com.genpact.custommapper.AdminRowMapper;
import com.genpact.dao.AdminDAO;

import com.genpact.pojo.Admin;


@Service
public class AdminDAOImpl implements AdminDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public boolean checkAdmin(Admin admin) {
		
		boolean b = true;
		String query = "SELECT * FROM admin WHERE adminID = ? and adminPassword = ?";
		
		try {
			b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
				
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setString(1, admin.getAdminID());
					ps.setString(2, admin.getAdminPassword());
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.isBeforeFirst())
						return true;
					else
						return false;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}


	@Override
	public Admin getAdminDetail(String adminID) {
		
		String query = "SELECT * FROM admin WHERE adminID=" 
                +adminID;
		
		List<Admin> adList = new ArrayList<Admin>();
		
		try {
			
			adList = jdbcTemplate.query(query, new AdminRowMapper());
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		if(adList.size()>0)
			return adList.get(0);
     else 
    	 return new Admin();
		
	}
}











