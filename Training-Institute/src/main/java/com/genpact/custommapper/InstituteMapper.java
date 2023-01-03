package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.pojo.Institute;

public class InstituteMapper {
	
	public static Institute mapInstitute(ResultSet rs) throws SQLException
	{
		Institute institute = new Institute();
		
		institute.setInstituteID(rs.getInt("instituteID"));
		institute.setInstituteName(rs.getString("instituteName"));
		institute.setAffiliationDate(rs.getDate("affiliationDate"));
		institute.setAddress(rs.getString("address"));
		institute.setSeats(rs.getInt("seats"));
		institute.setFilledSeats(rs.getInt("filledSeats"));
		
		return institute;
	}

}
