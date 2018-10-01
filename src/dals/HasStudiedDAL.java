package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import model.HasStudied;
import model.Studies; 

import databaseConnection.DatabaseConnection;

public class HasStudiedDAL {
	
    public boolean insertHasStudied(HasStudied hasStudied) throws SQLException {
      	
      	 
      	 Connection con = null;
      	 PreparedStatement state = null;
      	 try {
      		 con = DatabaseConnection.getConnection();
   
      		 
      		 state = con.prepareStatement("INSERT INTO HasStudied VALUES (?, ?, ?");
      		 state.setString(1, hasStudied.getStudentSsn());
      		 state.setString(2, hasStudied.getCourseCode());
      		 state.setString(3, hasStudied.getGrade());
      		 
      		
      		 int rows = state.executeUpdate();
      		 if (rows == 1) {
      			 return true;
      		 }
      		 return false;
      	 } finally {
      		 DatabaseConnection.closeResources(con, state);
      	 }
       }
       
       public boolean removeHasStudied(String studentSsn, String courseCode) throws SQLException {
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
	public HasStudied getHasStudied(String studentSsn, String courseCode, String grade)throws SQLException{
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM HasStudiet WHERE studentSsn = ? AND courseCode = ?" );
			
			state.setString(1, studentSsn);
			state.setString(2, courseCode);
			
			ResultSet rs = state.executeQuery();
			if(rs.next()) {
				 grade = rs.getString("grade");
				
				return new HasStudied(studentSsn, courseCode, grade);
			}
		return null;
		
	}finally {
		DatabaseConnection.closeResources(con, state);
	}
	}
	 public ArrayList<HasStudied> getAllHasStudied() throws SQLException {
		 Connection con = null;
		 PreparedStatement state = null;
		 
		 try {
			 con = DatabaseConnection.getConnection();
			 state = con.prepareStatement("SELECT * FROM Studied WHERE studentSsn = ? AND courseCode = ?");
			 
			 
	         
			 ResultSet rs = state.executeQuery();
	            ArrayList<HasStudied> hasStudied = new ArrayList<>();
	            while (rs.next()) {
	                String studentSsn = rs.getString("studentSsn");
	                String courseCode = rs.getString("courseCode"); 
	                String grade = rs.getString("grade");
	                
	                HasStudied studied = new HasStudied(studentSsn, courseCode, grade);
	                hasStudied.add(studied);
	            }
	            return hasStudied;
	        } finally {
	        	 DatabaseConnection.closeResources(con, state);
	        }
	    }
}