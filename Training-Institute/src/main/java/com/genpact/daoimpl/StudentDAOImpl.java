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

import com.genpact.custommapper.RequestRowMapper;
import com.genpact.custommapper.StudentRowMapper;
import com.genpact.dao.StudentDAO;
import com.genpact.pojo.Request;
import com.genpact.pojo.Student;

@Service
public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	@Override
	public boolean checkStudent(Student student) {
		
		boolean b = true;
		String query = "SELECT * FROM student WHERE studentID = ? and studentPassword = ?";
		
		try {
			b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
				
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1, student.getStudentID());
					ps.setString(2, student.getStudentPassword());
					
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
	public boolean updateStudent(Student student) {
		boolean b = false;
		String query = "UPDATE student SET emailID = ? , studentName = ? , qualification = ?, number = ?, address = ? WHERE studentID= ?";
		
		try {
			
			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
				
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setString(1, student.getEmailID());
					ps.setString(2, student.getStudentName());
					ps.setString(3, student.getQualification());
					ps.setString(4, student.getNumber());
					ps.setString(5, student.getAddress());
					ps.setInt(6, student.getStudentID());
					
					
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



	@Override
	public boolean addNewStudent(Student student) {
		boolean b = false;
		String query = "INSERT INTO student( emailID, studentName, qualification, studentPassword, number, address) "
				+ "values (?,?,?,?,?,?)";
		
		int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setString(1, student.getEmailID());
				ps.setString(2, student.getStudentName());
				ps.setString(3, student.getQualification());
				ps.setString(4, student.getStudentPassword());
				ps.setString(5, student.getNumber());
				ps.setString(6, student.getAddress());
				
				return ps.executeUpdate();
			}
		});
		
		if(count > 0)
			b = true;
		
		return b;
	}



	@Override
	public List<Student> getAllStudents() {
		
		List<Student> lst = new ArrayList<>();
		
		String query = "SELECT studentID, emailID,  instituteID, studentName, qualification, number, address FROM student";
		
		try {
		
		lst = jdbcTemplate.query(query, new StudentRowMapper());
		
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
		
		return lst;
	}



	@Override
	public Student getStudentDetail(int studentID) {
		
		String query = "SELECT * FROM student WHERE studentID=" 
                +studentID;
		
		List<Student> instList = new ArrayList<Student>();
		
		try {
			
			instList = jdbcTemplate.query(query, new StudentRowMapper());
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		if(instList.size()>0)
			return instList.get(0);
     else 
    	 return new Student();
}



	@Override
	public List<Request> viewAllResponse(int studentID) {
		
		List<Request> lstList = new ArrayList<Request>();
		
		String query = "SELECT * FROM admissionrequest WHERE userID=" 
                +studentID;
		
		try {
			
			lstList = jdbcTemplate.query(query, new RequestRowMapper());
			
		} catch (Exception e) {
			e.printStackTrace();
			lstList.clear();
			return lstList;
		}
		
		return lstList;
		
	}
	
}











