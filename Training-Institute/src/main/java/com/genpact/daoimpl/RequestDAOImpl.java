package com.genpact.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import com.genpact.custommapper.CourseRowMapper;
import com.genpact.custommapper.InstituteRowMapper;
import com.genpact.custommapper.RequestMapper;
import com.genpact.custommapper.RequestRowMapper;
import com.genpact.dao.RequestDAO;
import com.genpact.pojo.Course;
import com.genpact.pojo.Institute;
import com.genpact.pojo.Request;

@Service
public class RequestDAOImpl implements RequestDAO{

    private JdbcTemplate jdbcTemplate;
	
    @Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	

	@Override
	public boolean submitRequest(Request request) {
		boolean b = false;
		String query = "INSERT INTO admissionrequest(userID, instituteID, courseID, requestDate) VALUES(?,?,?,?)";
		
		try {
			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
				
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1, request.getUserID());
					ps.setInt(2, request.getInstituteID());
					ps.setInt(3, request.getCourseID());
					ps.setDate(4, request.getRequestDate());
					
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
	public Request getRequestStatus(int requestID) {
		
		Request request = null;
		String query = "SELECT * FROM request WHERE requestID = ?";
		
		try {
			
			request = jdbcTemplate.execute(query, new PreparedStatementCallback<Request>() {
				
				@Override
				public Request doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1, requestID);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.isBeforeFirst())
					{
						rs.next();
						Request rqt = RequestMapper.mapRequest(rs);
						return rqt;
					}
					else
						return null;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return request;
	}

	@Override
	public List<Request> viewAllRequestForInstitute(int instituteID) {
		
		List<Request> lst = new ArrayList<>();
		
		String query = "SELECT userID, courseID, institutionID, requestDate FROM request  where instituteID = ?";
		
		try {
		
		lst = jdbcTemplate.query(query, new RequestRowMapper());
		
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
		return lst;
	}

	@Override
	public List<Institute> getAllInstitutes() {
		List<Institute> lst = new ArrayList<>();
        String query = "SELECT instituteID, instituteName, affiliationDate, address, seats, filledSeats FROM institute";
        try {
            lst = jdbcTemplate.query(query, new InstituteRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            lst.clear();
            return lst;
        }
        return lst;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> lst = new ArrayList<>();
        String query = "SELECT courseID, courseName, instituteID FROM course";

        try {
            lst = jdbcTemplate.query(query, new CourseRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            lst.clear();
            return lst;
        }
        return lst;
	}
	
	@Override
    public boolean isAlreadyRequested(Request request) {
        boolean b = false;
        String query = "SELECT count(*) AS reqCount FROM admissionrequest WHERE userID = ? AND courseID = ? AND instituteID = ?";
        try {
            b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                    ps.setInt(1, request.getUserID());
                    ps.setInt(3, request.getInstituteID());
                    ps.setInt(2, request.getCourseID());

                    ResultSet rs = ps.executeQuery();

                    if (rs.isBeforeFirst()) {
                        rs.next();
                        int count = rs.getInt("reqCount");
                        if(count == 0) {
                            return false;
                        }
                        return true;
                    }
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

}
