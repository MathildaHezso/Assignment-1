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

	public ArrayList<String> getCoursesCourseCode() throws SQLException {
		return this.cDAL.getCoursesCourseCode();
	}

	public boolean insertCourse(Course c) throws SQLException {
		return this.cDAL.insertCourse(c);
	}

	public boolean removeCourse(String courseCode, String courseName) throws SQLException {
		return this.cDAL.removeCourse(courseCode, courseName);
	}

	public ArrayList<Studies> getStudentStudiesByCourseCode(String courseCode) throws SQLException {
		return this.stDAL.getStudentStudiesByCourseCode(courseCode);
	}

	public ArrayList<Studies> getStudentStudiesBySsn(String studentSsn) throws SQLException {
		return this.stDAL.getStudentStudiesBySsn(studentSsn);
	}

	public ArrayList<String> getStudentSsnByCourseCodeStudies(String courseCode) throws SQLException {
		return this.stDAL.getStudentSsnByCourseCodeStudies(courseCode);
	}

	public boolean insertStudies(Studies studies) throws SQLException {
		return this.stDAL.insertStudies(studies);
	}

	public boolean removeStudies(String studentSsn, String courseCode) throws SQLException {
		return this.stDAL.removeStudies(studentSsn, courseCode);
	}

	public boolean insertHasStudied(HasStudied hasStudied) throws SQLException {   
		return this.hsDAL.insertHasStudied(hasStudied);
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
}
