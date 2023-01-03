package com.genpact.custommapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.pojo.Course;


public class CourseMapper {
	
	
	public static Course mapCourse(ResultSet rs) throws SQLException
	{
		
		Course course = new Course();
		course.setCourseID(rs.getInt("courseID"));
		course.setCourseName(rs.getString("courseName"));
		course.setInstituteID(rs.getInt("instituteID"));
		
		return course;
	}
}
