package model;

import java.util.ArrayList;

public class Course {

	private String courseCode;
	private String courseName;
	private int credit;
	private ArrayList<Student> students = new ArrayList<Student>();

	public String getCourseCode()     {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

