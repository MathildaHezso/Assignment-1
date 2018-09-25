package assignmentOne;

import java.util.ArrayList;

public class Student {

	private int ssn;
	private String name;
	private String address;
	private String mail;
	private ArrayList<Course> courses = new ArrayList<Course>();

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public void addCourses(Course c) {
		courses.add(c);
	}

	public Course findCourse(String courseCode) {
		for (Course c : courses) {
			if (courseCode.equals(c.getCourseCode())) {
				return c;
			}
		}
		return null;
	}

	public void removeCourse(String courseCode) {
		Course c = this.findCourse(courseCode);
		if (c != null) {
			courses.remove(c);
		}
	}
}
