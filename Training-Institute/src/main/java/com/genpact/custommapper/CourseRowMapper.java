package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.pojo.Course;

public class CourseRowMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Course course = new Course();
		course.setCourseID(rs.getInt("courseID"));
		course.setCourseName(rs.getString("courseName"));
		course.setInstituteID(rs.getInt("instituteID"));
		
		return course;
	}
}
