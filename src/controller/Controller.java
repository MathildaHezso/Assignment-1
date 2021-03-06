package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dals.CourseDAL;
import dals.StudiesDAL;
import dals.StudentDAL;
import dals.HasStudiedDAL;

import model.Student;
import model.Course;
import model.Studies;
import model.HasStudied;

public class Controller {

	private StudentDAL sDAL;
	private CourseDAL cDAL;
	private StudiesDAL stDAL;
	private HasStudiedDAL hsDAL;

	public Controller() {
		this.sDAL = new StudentDAL();
		this.cDAL = new CourseDAL();
		this.stDAL = new StudiesDAL();
		this.hsDAL = new HasStudiedDAL();
	}

	public List<Student> getAllStudents() throws SQLException {
		return this.sDAL.getAllStudents();
	}

	public Student getStudent(String ssn) throws SQLException {
		return this.sDAL.getStudent(ssn);
	}

	public boolean removeStudent(String ssn) throws SQLException {
		return this.sDAL.removeStudent(ssn);
	}

	public boolean insertStudent(String ssn, String name, String address, String email) throws SQLException {
		Student s = new Student(ssn, name, address, email);
		return this.sDAL.insertStudent(s);
	}

	public ArrayList<Course> getAllCourses() throws SQLException {
		return this.cDAL.getAllCourses();
	}

	public Course getCourse(String courseCode) throws SQLException {
		return this.cDAL.getCourse(courseCode);
	}

	public boolean insertCourse(String courseCode, String courseName, int credit) throws SQLException {
		Course c = new Course(courseCode, courseName, credit);
		return this.cDAL.insertCourse(c);

	}

	public boolean removeCourse(String courseCode) throws SQLException {
		return this.cDAL.removeCourse(courseCode);
	}

	public boolean insertStudies(String studentSsn, String courseCode) throws SQLException {
		Studies studies = new Studies(studentSsn, courseCode);
		return this.stDAL.insertStudies(studies);
	}

	public boolean removeStudies(String studentSsn, String courseCode) throws SQLException {
		return this.stDAL.removeStudies(studentSsn, courseCode);
	}

	public boolean insertHasStudied(String studentSsn, String courseCode, String grade) throws SQLException {
		HasStudied h = new HasStudied(studentSsn, courseCode, grade);
		return this.hsDAL.insertHasStudied(h);
	}

	public HasStudied getHasStudied(String studentSsn, String courseCode) throws SQLException {
		return this.hsDAL.getHasStudied(studentSsn, courseCode);

	}

	public ArrayList<HasStudied> getAllHasStudied(String courseCode) throws SQLException {
		return this.hsDAL.getAllHasStudied(courseCode);
	}

	public boolean removeHasStudied(String studentSsn, String courseCode) throws SQLException {
		return this.hsDAL.removeHasStudied(studentSsn, courseCode);
	}

	public List<Studies> getAllStudies() throws SQLException {
		return this.stDAL.getAllStudies();
	}

	public List<HasStudied> getAllStudied(String studentSsn, String courseCode) throws SQLException {
		return this.hsDAL.getAllStudied(studentSsn, courseCode);
	}

	public Studies getAllStudies(String studentSsn, String courseCode) throws SQLException {
		return this.stDAL.getAllStudies(studentSsn, courseCode);
	}

}
