package assignmentOne;

public class HasStudied {

	private String studentSsn;
	private String courseCode;
	private int grade;
	
	public HasStudied(String studentSsn, String courseCode, int grade){
		this.studentSsn = studentSsn;
		this.courseCode = courseCode;
		this.grade = grade;
	}

	public String getStudentSsn() {
		return studentSsn;
	}

	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
