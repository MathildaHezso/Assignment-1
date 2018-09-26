package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import model.HasStudied;

import databaseConnection.DatabaseConnection;

public class HasStudiedDAL {
	
    public boolean insertHasStudued(HasStudied hasStudied) throws SQLException {
      	 String studentSsn = hasStudied.getStudentSsn();
      	 String courseCode = hasStudied.getCourseCode();
      	 int grade = hasStudied.getGrade();
      	 
      	 Connection con = null;
      	 PreparedStatement state = null;
      	 try {
      		 con = DatabaseConnection.getConnection();
      		 state = con.prepareStatement("INSERT INTO HasStudied VALUES (?, ?, ?");
      		 state.setString(1, studentSsn);
      		 state.setString(2, courseCode);
      		 state.setInt(3, grade);
      		 
      		 int rows = state.executeUpdate();
      		 if (rows == 1) {
      			 return true;
      		 }
      		 return false;
      	 } finally {
      		 DatabaseConnection.closeResources(con, state);
      	 }
       }
       
       public boolean deleteHasStudied(String studentSsn, String courseCode) throws SQLException {
      	 Connection con = null;
      	 PreparedStatement state = null;
      	 try {
      		 con = DatabaseConnection.getConnection();
      		 state = con.prepareStatement("DELETE FROM HasStudied WHERE studentSsn = ? AND courseCode = ?");
      		 state.setString(1, studentSsn);
      		 state.setString(2, courseCode);
      		 
      		 int rows = state.executeUpdate();
      		 if (rows == 1) {
      			 return true;
      		 }
      		 return false;
      	 } finally {
      		 DatabaseConnection.closeResources(con, state);
      	 }
       }
	public HasStudied getHasStudied(String studentSsn, String courseCode)throws SQLException{
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM HasStudiet WHERE studentSsn = ? AND courseCode = ?" );
			
			state.setString(1, studentSsn);
			state.setString(2, courseCode);
			
			ResultSet rs = state.executeQuery();
			if(rs.next()) {
				int grade = rs.getInt("grade");
				
				return new HasStudied(studentSsn, courseCode, grade);
			}
		return null;
		
	}finally {
		DatabaseConnection.closeResources(con, state);
	}
	}
	 public ArrayList<HasStudied> getAllHasStudied(String courseCode) throws SQLException {
		 Connection con = null;
		 PreparedStatement state = null;
		 
		 try {
			 con = DatabaseConnection.getConnection();
			 state = con.prepareStatement("SELECT * FROM Studied WHERE courseCode = ? ORDER BY grade");
			 
			 state.setString(1, courseCode);
	         
			 ResultSet rs = state.executeQuery();
	            ArrayList<HasStudied> hasStudied = new ArrayList<>();
	            while (rs.next()) {
	                String studentSsn = rs.getString("studentSsn");
	                int grade = rs.getInt("grade");
	                
	                HasStudied studied = new HasStudied(studentSsn, courseCode, grade);
	                hasStudied.add(studied);
	            }
	            return hasStudied;
	        } finally {
	        	 DatabaseConnection.closeResources(con, state);
	        }
	    }
}