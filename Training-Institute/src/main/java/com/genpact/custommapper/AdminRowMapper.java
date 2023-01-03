package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.pojo.Admin;

public class AdminRowMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
        Admin admin = new Admin();
		
		
		admin.setAdminID(rs.getString("adminID"));
		
		
		return admin;
	}
}
