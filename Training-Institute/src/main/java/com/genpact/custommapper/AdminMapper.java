package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.pojo.Admin;

public class AdminMapper {
	
	public static Admin mapStudent(ResultSet rs) throws SQLException
	{
		Admin pr = new Admin();
		
		pr.setAdminID(rs.getString("adminID"));
		
		
		return pr;
	}

}
