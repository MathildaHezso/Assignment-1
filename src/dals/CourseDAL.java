package dals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Course;
import databaseConnection.DatabaseConnection;

public class CourseDAL {
    
    public ArrayList<Course> getAllCourses() throws SQLException{
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = DatabaseConnection.getConnection();
            state = con.prepareStatement("SELECT * FROM Course");
            
            ResultSet rs = state.executeQuery();
            
            ArrayList<Course> allCourses = new ArrayList<>();
            while (rs.next()) {
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("CourseName");
                int credit = rs.getInt("Credit");
                
                Course c = new Course(courseCode, courseName, credit);
                allCourses.add(c);
            }
            return allCourses;
        } finally {
            DatabaseConnection.closeResources(con, state);
        }
    }
    
    public Course getCourse(String courseCode) throws SQLException {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = DatabaseConnection.getConnection();
            state = con.prepareStatement("SELECT * FROM Course WHERE courseCode = ?");
            state.setString(1, courseCode);
            
            ResultSet rs = state.executeQuery();
            if (rs.next()) {
                String courseName = rs.getString("courseName");
                int credit = rs.getInt("credit");
                
                return new Course(courseCode, courseName, credit);
            }
            return null;
        } finally {
            DatabaseConnection.closeResources(con, state);
        }
    }
   
    
    public boolean insertCourse(Course c) throws SQLException {
        String courseCode = c.getCourseCode();
        String courseName = c.getCourseName();
        int credit = c.getCredit();
        
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = DatabaseConnection.getConnection();
            state = con.prepareStatement("INSERT INTO Course VALUES(?, ?, ?)");
            state.setString(1, courseCode);
            state.setString(2, courseName);
            state.setInt(3, credit);
            
            int row = state.executeUpdate();
            if (row == 1) {
                return true;
            }
            return false;
        } finally {
            DatabaseConnection.closeResources(con, state);
        }
    }
    
    public boolean removeCourse(String courseCode) throws SQLException {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = DatabaseConnection.getConnection();
            state = con.prepareStatement("DELETE FROM Course WHERE courseCode = ?");
            state.setString(1, courseCode);
            
            int row = state.executeUpdate();
            if (row == 1) {
                return true;
            }
            return false;
        } finally {
            DatabaseConnection.closeResources(con, state);
        }
    }
}


