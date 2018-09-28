package dals;

import databaseConnection.DatabaseConnection;
import model.Student;

import java.sql.Connection;
import java.util.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAL {

	public List<Student> getAllStudents() throws SQLException {
		PreparedStatement state = null;
		Connection con = null;

		try {

			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM Student");

			ResultSet rs = state.executeQuery();

			List<Student> allStudents = new ArrayList<>();
			while (rs.next()) {
				String ssn = rs.getString("Ssn");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String email = rs.getString("Email");

				Student s = new Student(ssn, name, address, email);
				allStudents.add(s);
			}
			return allStudents;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}

	}

	public boolean insertStudent(Student student) throws SQLException {
		String ssn = student.getSsn();
		String name = student.getName();
		String address = student.getAddress();
		String email = student.getEmail();

		Connection con = null;
		PreparedStatement state = null;

		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("INSERT INTO Student VALUES(?,?,?,?)");

			state.setString(1, ssn);
			state.setString(2, name);
			state.setString(3, address);
			state.setString(4, email);

			int row = state.executeUpdate();
			if (row == 1) {
				return true;
			}
			return false;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}
	}

	public Student getStudent(String ssn) throws SQLException {
		Connection con = null;
		PreparedStatement state = null;

		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("SELECT * FROM Student WHERE ssn = ?");
			state.setString(1, ssn);

			ResultSet rs = state.executeQuery();

			Student student = null;
			if (rs.next()) {
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String email = rs.getString("Email");

				student = new Student(ssn, name, address, email);
			}
			return student;
		} finally {
			DatabaseConnection.closeResources(con, state);
		}

	}

	public boolean removeStudent(String ssn) throws SQLException {

		Connection con = null;
		PreparedStatement state = null;

		try {
			con = DatabaseConnection.getConnection();
			state = con.prepareStatement("DELETE FROM Student WHERE ssn = ? ");
			state.setString(1, ssn);

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
