package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.pojo.Institute;

public class InstituteRowMapper implements RowMapper<Institute>{

	@Override
	public Institute mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
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
