package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HasStudied;
import model.Studies;

import databaseConnection.DatabaseConnection;

public class HasStudiedDAL {

	public boolean insertHasStudied(HasStudied hasStudied) throws SQLException {

		String studentSsn = hasStudied.getStudentSsn();
		String courseCode = hasStudied.getCourseCode();
		String grade = hasStudied.getGrade();
		
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();

			state = con.prepareStatement("INSERT INTO HasStudied VALUES (?, ?, ?)");
			state.setString(1, studentSsn);
			state.setString(2, courseCode);
			state.setString(3, grade);

			int rows = state.executeUpdate();
			if (rows == 1) {
				
				StudiesDAL studiesDAL = new StudiesDAL(); 
				studiesDAL.removeStudies(studentSsn, courseCode);

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

	public HasStudied getHasStudied(String studentSsn, String courseCode) throws SQLException {
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM HasStudied WHERE studentSsn = ? AND courseCode = ?");

			state.setString(1, studentSsn);
			state.setString(2, courseCode);

			ResultSet rs = state.executeQuery();
			if (rs.next()) {
				String grade = rs.getString("grade");

				return new HasStudied(studentSsn, courseCode, grade);
			}
			return null;

		} finally {
			DatabaseConnection.closeResources(con, state);
		}
	}

	public ArrayList<HasStudied> getAllHasStudied(String courseCode) throws SQLException {
		Connection con = null;
		PreparedStatement state = null;

		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM HasStudied WHERE courseCode = ?");
			state.setString(1, courseCode);
			
			ResultSet rs = state.executeQuery();
			ArrayList<HasStudied> hasStudied = new ArrayList<HasStudied>();
			while (rs.next()) {
				String studentSsn = rs.getString(1);
				String grade = rs.getString(3);

				HasStudied studied = new HasStudied(studentSsn, courseCode, grade);
				hasStudied.add(studied);
			}
			return hasStudied;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}
	}
	
	public ArrayList<HasStudied> getAllStudied(String studentSsn, String courseCode) throws SQLException {
		PreparedStatement state = null;
		Connection con = null;

		try {

			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM HasStudied WHERE studentSsn = ? AND courseCode = ?");
			state.setString(1, studentSsn);
			state.setString(2, courseCode);
			ResultSet rs = state.executeQuery();

			ArrayList<HasStudied> allHasStudied = new ArrayList<HasStudied>();
			while (rs.next()) {
				
				String grade = rs.getString(3); 
				

				HasStudied studied = new HasStudied(studentSsn, courseCode, grade);
				allHasStudied.add(studied);
			}
			return allHasStudied;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}

	}
}



