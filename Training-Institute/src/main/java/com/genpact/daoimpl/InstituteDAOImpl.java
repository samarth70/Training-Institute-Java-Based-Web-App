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

import com.genpact.custommapper.FeedbackRowMapper;
import com.genpact.custommapper.InstituteRowMapper;
import com.genpact.custommapper.RequestRowMapper;
import com.genpact.custommapper.StudentRowMapper;
import com.genpact.dao.InstituteDAO;
import com.genpact.pojo.Student;
import com.genpact.pojo.Feedback;
import com.genpact.pojo.Institute;
import com.genpact.pojo.Request;


@Service
public class InstituteDAOImpl implements InstituteDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public boolean updateInstitute(Institute institute) {
		boolean b = false;
		String query = "UPDATE institute SET instituteName = ? , affiliationDate = ? , address = ?, seats = ?, filledSeats= ? WHERE instituteID = ?";
		
		try {
			
			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
				
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setString(1, institute.getInstituteName());
					ps.setDate(2, institute.getAffiliationDate());
					ps.setString(3, institute.getAddress());
					ps.setInt(4, institute.getSeats());
					ps.setInt(5,institute.getFilledSeats());
					ps.setInt(6,  institute.getInstituteID());
					
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
	public boolean deleteInstitute(int instituteID) {
		boolean b = false;
		String query = "DELETE FROM institute WHERE instituteID = ?";
		
		try {
			
			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
				
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1, instituteID);
					
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
	public boolean addNewInstitute(Institute institute) {
		boolean b = false;
		String query = "INSERT INTO institute(instituteName, institutePassword, affiliationDate,  address, seats, filledSeats) VALUES(?,?,?,?,?,?)";
		
		try {
			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
				
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setString(1, institute.getInstituteName());
					ps.setString(2, institute.getInstitutePassword());
					ps.setDate(3, institute.getAffiliationDate());
					ps.setString(4, institute.getAddress());
					ps.setInt(5, institute.getSeats());
					ps.setInt(6, institute.getFilledSeats());
					
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
	public boolean checkInstitute(Institute institute) {
		boolean b = true;
		String query = "SELECT * FROM institute WHERE instituteID = ? and institutePassword = ?";
		
		try {
			b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
				
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1, institute.getInstituteID());
					ps.setString(2, institute.getInstitutePassword());
					
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
	
	public Institute getInstituteDetails(int instituteID)
	{
		String query = "SELECT instituteID, instituteName, affiliationDate, address, seats, filledSeats FROM institute WHERE instituteID=" 
	                      +instituteID;
		
		List<Institute> instList = new ArrayList<Institute>();
		
		try {
			instList = jdbcTemplate.query(query, new InstituteRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(instList.size()>0)
			return instList.get(0);
		else 
			return new Institute();
}


	@Override
	public List<Request> getAllRequests(int instituteID) {
		
		List<Request> lstList = new ArrayList<Request>();
		
		String query = "SELECT requestID, userID, studentName, admissionrequest.instituteID, courseID, requestDate, status FROM admissionrequest"
			    + " INNER JOIN student ON admissionrequest.userID=student.studentID WHERE admissionrequest.instituteID=" 
	                +instituteID;
		
		try {
			
			lstList = jdbcTemplate.query(query, new RequestRowMapper());
			
		} catch (Exception e) {
			e.printStackTrace();
			lstList.clear();
			return lstList;
		}
		
		return lstList;
		
	}
	

	@Override
	public List<Student> getAllStudents(int instituteID) {
			
		List<Student> lstList = new ArrayList<Student>();
			
			String query = "SELECT studentID, studentName, instituteID, qualification, emailID, address, number from STUDENT WHERE instituteID="
		                +instituteID;
			
			try {
				
				lstList = jdbcTemplate.query(query, new StudentRowMapper());
				
			} catch (Exception e) {
				e.printStackTrace();
				lstList.clear();
				return lstList;
			}
			
			return lstList;
			
		}


	@Override
	public boolean setStudentRequestStatus(Request studentRequest, int status) {
		boolean b = false;
        String query = "UPDATE admissionrequest SET status = ? WHERE userID = ? AND courseID = ? AND instituteID = ?";
        try {
            int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                    ps.setInt(1, status);
                    ps.setInt(2, studentRequest.getUserID());
                    ps.setInt(3, studentRequest.getCourseID());
                    ps.setInt(4, studentRequest.getInstituteID());
                    return ps.executeUpdate();
                }
            });

            if (count > 0)
                b = true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return b;
	}


	@Override
	public List<Feedback> getAllFeedbacks(int instituteID) {
		List<Feedback> lstList = new ArrayList<Feedback>();
		
		String query = "SELECT feedbackID, userID, instituteID, description, feedbackDate from FEEDBACK WHERE instituteID="
	                +instituteID;
		
		try {
			
			lstList = jdbcTemplate.query(query, new FeedbackRowMapper());
			
		} catch (Exception e) {
			e.printStackTrace();
			lstList.clear();
			return lstList;
		}
		
		return lstList;
		
	}
	
	@Override
    public boolean isSeatAvailable(int instituteID) {
        boolean b = false;
        String query = "SELECT seats, filledSeats FROM institute WHERE instituteID = ?";
        try {
            b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                    ps.setInt(1, instituteID);
                    ResultSet rs = ps.executeQuery();

                    if (rs.isBeforeFirst()) {
                        rs.next();
                        int totalSeats = rs.getInt("seats");
                        int filledSeats = rs.getInt("filledSeats");
                        if (totalSeats > filledSeats) {
                            return true;
                        } else {
                            return false;
                        }
                    } else
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
    public boolean requireAttention(Request studentRequest) {
        boolean b = false;
        String query = "SELECT status FROM admissionrequest WHERE userID = ? AND courseID = ? AND instituteID = ?";
        try {
            b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                    ps.setInt(1, studentRequest.getUserID());
                    ps.setInt(2, studentRequest.getCourseID());
                    ps.setInt(3, studentRequest.getInstituteID());
                    ResultSet rs = ps.executeQuery();

                    if (rs.isBeforeFirst()) {
                        rs.next();
                        int status = rs.getInt("status");
                        
                        // Is Pending
                        if (status == 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else
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
    public boolean incrementFilledSeatByOne(int instituteID) {
        boolean b = false;
        String query = "UPDATE institute SET filledSeats = filledSeats + 1 WHERE instituteID = ?";
        try {
            int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                    ps.setInt(1, instituteID);
                    return ps.executeUpdate();
                }
            });

            if (count > 0)
                b = true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return b;
    }
    
    @Override
    public boolean updateStudentWithInstitute(Request studentRequest) {
        boolean b = false;
        String query = "UPDATE student SET instituteID = ? WHERE studentID = ?";
        try {
            int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                    ps.setInt(1, studentRequest.getInstituteID());
                    ps.setInt(2, studentRequest.getUserID());
                    return ps.executeUpdate();
                }
            });

            if (count > 0)
                b = true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return b;
    }
	
}








