package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.DatabaseConnection;
import model.HasStudied;
import model.Student;
import model.Studies;

public class StudiesDAL {

	public boolean insertStudies(Studies studies) throws SQLException {
		String studentSsn = studies.getStudentSsn();
		String courseCode = studies.getCourseCode();

		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("INSERT INTO Studies VALUES (?, ?)");
			state.setString(1, studentSsn);
			state.setString(2, courseCode);

			int row = state.executeUpdate();
			if (row == 1) {
				return true;
			}
			return false;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}
	}

	public boolean removeStudies(String studentSsn, String courseCode) throws SQLException {
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("DELETE FROM Studies WHERE studentSsn = ? AND courseCode = ?");
			state.setString(1, studentSsn);
			state.setString(2, courseCode);

			int row = state.executeUpdate();
			if (row == 1) {
				return true;
			}
			return false;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}
	}

	public List<Studies> getAllStudies() throws SQLException {
		PreparedStatement state = null;
		Connection con = null;

		try {

			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM Studies");

			ResultSet rs = state.executeQuery();

			List<Studies> allStudies = new ArrayList<>();
			while (rs.next()) {
				String studentSsn = rs.getString("studentSsn");
				String courseCode = rs.getString("courseCode");

				Studies studies = new Studies(studentSsn, courseCode);
				allStudies.add(studies);
			}
			return allStudies;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}

	}

	public Studies getAllStudies(String studentSsn, String courseCode) throws SQLException {
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM Studies WHERE studentSsn = ? AND courseCode = ?");

			state.setString(1, studentSsn);
			state.setString(2, courseCode);

			ResultSet rs = state.executeQuery();
			if (rs.next()) {

				return new Studies(studentSsn, courseCode);
			}
			return null;

		} finally {
			DatabaseConnection.closeResources(con, state);
		}
	}
}
