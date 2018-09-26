package assignmentOne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import assignmentOne.HasStudied;


public class HasStudiedDal {
	
    public boolean insertHasStudued(HasStudied hasStudied) throws SQLException {
      	 String studentSsn = hasStudied.getStudentSsn();
      	 String courseCode = hasStudied.getCourseCode();
      	 
      	 Connection con = null;
      	 PreparedStatement state = null;
      	 try {
      		 con = DatabaseConnection.getConnection();
      		 state = con.prepareStatement("INSERT INTO HasStudied VALUES (?, ?");
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

	

}
