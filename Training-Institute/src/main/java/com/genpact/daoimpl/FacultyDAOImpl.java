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

import com.genpact.custommapper.FacultyMapper;
import com.genpact.custommapper.FacultyRowMapper;
import com.genpact.dao.FacultyDAO;
import com.genpact.pojo.Faculty;

@Service
public class FacultyDAOImpl implements FacultyDAO{

	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addNewFaculty(Faculty faculty) {
		boolean b = false;
		String query = "INSERT INTO faculty(facultyName,instituteID) values (?,?)";
		
		int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setString(1, faculty.getFacultyName());
				ps.setInt(2, faculty.getInstituteID());
				
				return ps.executeUpdate();
			}
		});
		
		if(count > 0)
			b = true;
		
		return b;
	}

	@Override
	public List<Faculty> getAllFaculties() {
		
		List<Faculty> lst = new ArrayList<>();
		
		String query = "SELECT * FROM faculty";
		
		try {
		
		lst = jdbcTemplate.query(query, new FacultyRowMapper());
		
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
		
		return lst;
	}

	
	@Override
	public Faculty getAllFacultiesByInstitute(int instituteID) {
	
		Faculty faculty = null;
		String query = "SELECT * FROM faculty WHERE instituteID = ?";
		
		try {
			
			faculty = jdbcTemplate.execute(query, new PreparedStatementCallback<Faculty>() {


				@Override
				public Faculty doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					ps.setInt(1, instituteID);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.isBeforeFirst())
					{
						rs.next();
						Faculty fac = FacultyMapper.mapFaculty(rs);
						return fac;
					}
					else
						return null;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return faculty;
		
	}

	@Override
	public boolean deleteFaculty(int facultyID) {
		boolean b = false;
		String query = "DELETE FROM faculty WHERE facultyID = ?";
		
		try {
			
			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
				
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1, facultyID);
					
					return ps.executeUpdate();
				}
			});
			
			if(count > 0)
				b = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}
	
}
