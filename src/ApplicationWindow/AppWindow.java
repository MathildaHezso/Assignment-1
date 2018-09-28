package ApplicationWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.*;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;

import javax.swing.JSpinner;

import java.awt.Font;
import javax.swing.JList;
import java.awt.Component;

import controller.Controller;
import model.Course;
import model.Student;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class AppWindow {

	private JFrame frame;

	private JButton btnRemoveStudent;
	private JButton btnAddStudent;
	private JButton btnFindStudent;
	private Controller controller;
	private JTextField textField_adminStudentSsn;
	private JTextField textField_adminStudentName;
	private JTextField textField_adminStudentAddress;
	private JTextField textField_adminStudentEmail;
	private JTextField textField_adminCourseCode;
	private JTextField textField_adminCourseName;
	private JTextField textField_adminCourseCredits;
	private JTextField textField_searchStudentSsn;
	private JTextField textField_searchCourseCode;
	private JTextField textField_searchResultCode;
	private JTextField textField_adminStudentCourseSsn;
	private JTextField textField_adminStudentCourseCode;
	private JTextField textField_adminHasStudiedSsn;
	private JTextField textField_adminHasStudiedCode;
	private JTable table_courseStudent;
	private JTable table_course;
	private JTable table_studentResults;
	private JTable table_courseResults;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		controller = new Controller();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JTabbedPane tabbedPane_Assignment1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 1", null, tabbedPane_Assignment1, null);

		JTabbedPane tabbedPane_Assignment2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 2", null, tabbedPane_Assignment2, null);

		JTabbedPane tabbedPane_Assignment3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 3", null, tabbedPane_Assignment3, null);

		JPanel panel = new JPanel();
		tabbedPane_Assignment1.addTab("Overview", null, panel, null);
		panel.setLayout(null);

		JTable studentList = new JTable(new DefaultTableModel(new String[] { "Ssn", "Name", "Address", "Email" }, 0));
		studentList.setFont(new Font("Open Sans", Font.PLAIN, 11));
		JScrollPane studentListPane = new JScrollPane(studentList);
		panel.add(studentListPane);
		studentListPane.setBounds(37, 103, 486, 123);

		JButton btnShowStudents = new JButton("Show All Students");
		btnShowStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					DefaultTableModel studentTable = (DefaultTableModel) studentList.getModel();
					studentTable.setRowCount(0);
					for (Student s : controller.getAllStudents()) {
						studentTable.addRow(new String[] { s.getSsn(), s.getName(), s.getAddress(), s.getEmail() });
					}

				} catch (Exception e1) {
					e1.printStackTrace();

				}

			}
		});
		btnShowStudents.setBounds(37, 61, 486, 23);
		panel.add(btnShowStudents);
		
		JTable courseList = new JTable(new DefaultTableModel(new String [] { "Course code", "Course code"},0));
		courseList.setFont(new Font("Open sans", Font.PLAIN,11));
		JScrollPane courseListPane = new JScrollPane(courseList);
		panel.add(courseListPane);
		courseListPane.setBounds(37, 334, 488, 123);


		JButton btnShowCourses = new JButton("Show All Courses");
		btnShowCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					DefaultTableModel courseTable = (DefaultTableModel) courseList.getModel(); 
					courseTable.setRowCount(0); 
					for(Course c : controller.getAllCourses()){
					courseTable.addRow(new String [] { c.getCourseCode(), c.getCourseName()});
		}
					
				}catch (Exception e1){
					e1.printStackTrace();
				}

			}
		});
		btnShowCourses.setBounds(37, 292, 486, 23);
		panel.add(btnShowCourses);

		JLabel lblOverview = new JLabel("OVERVIEW");
		lblOverview.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOverview.setBounds(241, 21, 80, 14);
		panel.add(lblOverview);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 259, 562, 2);
		panel.add(separator_3);

		JPanel panel_1 = new JPanel();
		tabbedPane_Assignment1.addTab("Administration", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		tabbedPane_Assignment1.addTab("Search", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lbl_Message = new JLabel("");
		lbl_Message.setBounds(308, 172, 81, 23);
		panel_1.add(lbl_Message);

		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(392, 129, 113, 23);
		panel_1.add(btnFindCourse);

		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(392, 148, 113, 23);
		panel_1.add(btnRemoveCourse);

		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAddCourse.setBounds(298, 129, 89, 23);
		panel_1.add(btnAddCourse);

		JButton btnShowGrade_1 = new JButton("Complete");
		btnShowGrade_1.setBounds(111, 399, 113, 23);
		panel_1.add(btnShowGrade_1);

		JButton btnComplete = new JButton("ADD");
		btnComplete.setActionCommand("");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComplete.setBounds(356, 399, 156, 23);
		panel_1.add(btnComplete);

		JButton btnShowGrade = new JButton("Show grade");
		btnShowGrade.setBounds(116, 124, 105, 23);
		panel_2.add(btnShowGrade);

		JButton btnShowResult = new JButton("Show result");
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnShowResult.setBounds(371, 91, 105, 23);
		panel_2.add(btnShowResult);

		JRadioButton rdbtnAddStudies = new JRadioButton("Add Studies");
		rdbtnAddStudies.setBounds(32, 315, 89, 23);
		panel_1.add(rdbtnAddStudies);

		JRadioButton rdbtnRemoveStudies = new JRadioButton("Remove Studies");
		rdbtnRemoveStudies.setBounds(121, 315, 103, 23);
		panel_1.add(rdbtnRemoveStudies);

		/*
		 * DefaultTableModel table = new DefaultTableModel(new String [] { "Ssn",
		 * "Name", "Address", "Email"}, 0); String tableSsn =
		 * controller.getAllStudents();
		 */

		/*
		 * table = new JTable(); scrollPane.setViewportView(table); table.setModel(new
		 * DefaultTableModel( new Object[][] { {null, null, null, null}, {null, null,
		 * null, null}, {null, null, null, null}, {null, null, null, null}, }, new
		 * String[] { "Ssn", "Name", "Address", "Email" } ));
		 */

		JLabel lblAddFind = new JLabel("Add / Find / Remove Student");
		lblAddFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind.setBounds(29, 30, 195, 14);
		panel_1.add(lblAddFind);

		JLabel lblAddFind_1 = new JLabel("Add / Find / Remove Course");
		lblAddFind_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind_1.setBounds(319, 30, 186, 14);
		panel_1.add(lblAddFind_1);

		JLabel lblAddremoveStudentFrom = new JLabel("Add/Remove Student from Course");
		lblAddremoveStudentFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddremoveStudentFrom.setBounds(29, 290, 195, 14);
		panel_1.add(lblAddremoveStudentFrom);

		JLabel lblAddCompletedCourse = new JLabel("Add Completed Course");
		lblAddCompletedCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddCompletedCourse.setBounds(376, 290, 136, 14);
		panel_1.add(lblAddCompletedCourse);

		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(51, 58, 46, 14);
		panel_1.add(lblSsn);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(51, 77, 46, 14);
		panel_1.add(lblName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(51, 101, 46, 14);
		panel_1.add(lblAddress);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(51, 120, 46, 14);
		panel_1.add(lblEmail);

		JLabel lblCourseCode = new JLabel("Course Code:");
		lblCourseCode.setBounds(319, 55, 68, 14);
		panel_1.add(lblCourseCode);

		JLabel lblCoureName = new JLabel("Course Name:");
		lblCoureName.setBounds(319, 77, 68, 14);
		panel_1.add(lblCoureName);

		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(329, 101, 46, 14);
		panel_1.add(lblCredits);

		JLabel lblGradeOnCourse = new JLabel("Grade on course:");
		lblGradeOnCourse.setBounds(356, 371, 87, 14);
		panel_1.add(lblGradeOnCourse);

		JLabel lblStudentSsn = new JLabel("Student SSN:");
		lblStudentSsn.setBounds(356, 326, 66, 14);
		panel_1.add(lblStudentSsn);

		JLabel lblCourseCode_1 = new JLabel("Course Code:");
		lblCourseCode_1.setBounds(356, 348, 68, 14);
		panel_1.add(lblCourseCode_1);

		JLabel lblStudentSsn_1 = new JLabel("* Student SSN:");
		lblStudentSsn_1.setBounds(29, 348, 81, 14);
		panel_1.add(lblStudentSsn_1);

		JLabel lblCourseCode_2 = new JLabel("Course Code:");
		lblCourseCode_2.setBounds(43, 371, 67, 14);
		panel_1.add(lblCourseCode_2);

		JLabel label = new JLabel("*");
		label.setBounds(228, 348, 22, 14);
		panel_1.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setBounds(228, 371, 16, 14);
		panel_1.add(label_1);

		JLabel lblResultForCompleted = new JLabel("Student Resuts");
		lblResultForCompleted.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultForCompleted.setBounds(90, 25, 117, 14);
		panel_2.add(lblResultForCompleted);

		JLabel lblCourseCode_3 = new JLabel("Course Code:");
		lblCourseCode_3.setBounds(293, 69, 79, 14);
		panel_2.add(lblCourseCode_3);

		JLabel lblStudentSsn_2 = new JLabel("Student SSN:");
		lblStudentSsn_2.setBounds(37, 69, 79, 14);
		panel_2.add(lblStudentSsn_2);

		JLabel lblCourseCode_4 = new JLabel("Course Code:");
		lblCourseCode_4.setBounds(37, 97, 88, 14);
		panel_2.add(lblCourseCode_4);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(70, 155, 46, 14);
		panel_2.add(lblResult);

		JLabel lblCourseResults = new JLabel("Course Results");
		lblCourseResults.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourseResults.setBounds(354, 25, 86, 14);
		panel_2.add(lblCourseResults);

		table_courseStudent = new JTable();
		table_courseStudent.setBounds(83, 445, 447, 40);
		panel_1.add(table_courseStudent);

		table_course = new JTable();
		table_course.setBounds(319, 205, 186, 50);
		panel_1.add(table_course);

		table_studentResults = new JTable();
		table_studentResults.setBounds(80, 186, 148, 128);
		panel_2.add(table_studentResults);

		table_courseResults = new JTable();
		table_courseResults.setBounds(346, 186, 154, 122);
		panel_2.add(table_courseResults);

		textField_adminStudentSsn = new JTextField();
		textField_adminStudentSsn.setBounds(111, 55, 113, 20);
		panel_1.add(textField_adminStudentSsn);
		textField_adminStudentSsn.setColumns(10);

		textField_adminStudentName = new JTextField();
		textField_adminStudentName.setBounds(111, 74, 113, 20);
		panel_1.add(textField_adminStudentName);
		textField_adminStudentName.setColumns(10);

		textField_adminStudentAddress = new JTextField();
		textField_adminStudentAddress.setBounds(111, 98, 113, 20);
		panel_1.add(textField_adminStudentAddress);
		textField_adminStudentAddress.setColumns(10);

		textField_adminStudentEmail = new JTextField();
		textField_adminStudentEmail.setBounds(111, 117, 113, 20);
		panel_1.add(textField_adminStudentEmail);
		textField_adminStudentEmail.setColumns(10);

		textField_adminCourseCode = new JTextField();
		textField_adminCourseCode.setBounds(392, 55, 113, 20);
		panel_1.add(textField_adminCourseCode);
		textField_adminCourseCode.setColumns(10);

		textField_adminCourseName = new JTextField();
		textField_adminCourseName.setBounds(392, 74, 113, 20);
		panel_1.add(textField_adminCourseName);
		textField_adminCourseName.setColumns(10);

		textField_adminCourseCredits = new JTextField();
		textField_adminCourseCredits.setBounds(392, 98, 113, 20);
		panel_1.add(textField_adminCourseCredits);
		textField_adminCourseCredits.setColumns(10);

		textField_adminStudentCourseSsn = new JTextField();
		textField_adminStudentCourseSsn.setBounds(111, 345, 113, 20);
		panel_1.add(textField_adminStudentCourseSsn);
		textField_adminStudentCourseSsn.setColumns(10);

		textField_adminStudentCourseCode = new JTextField();
		textField_adminStudentCourseCode.setBounds(111, 368, 113, 20);
		panel_1.add(textField_adminStudentCourseCode);
		textField_adminStudentCourseCode.setColumns(10);

		textField_adminHasStudiedSsn = new JTextField();
		textField_adminHasStudiedSsn.setBounds(426, 326, 86, 20);
		panel_1.add(textField_adminHasStudiedSsn);
		textField_adminHasStudiedSsn.setColumns(10);

		textField_adminHasStudiedCode = new JTextField();
		textField_adminHasStudiedCode.setBounds(426, 345, 86, 20);
		panel_1.add(textField_adminHasStudiedCode);
		textField_adminHasStudiedCode.setColumns(10);

		textField_searchStudentSsn = new JTextField();
		textField_searchStudentSsn.setBounds(116, 66, 105, 20);
		panel_2.add(textField_searchStudentSsn);
		textField_searchStudentSsn.setColumns(10);

		textField_searchCourseCode = new JTextField();
		textField_searchCourseCode.setBounds(116, 94, 105, 20);
		panel_2.add(textField_searchCourseCode);
		textField_searchCourseCode.setColumns(10);

		textField_searchResultCode = new JTextField();
		textField_searchResultCode.setBounds(371, 64, 105, 20);
		panel_2.add(textField_searchResultCode);
		textField_searchResultCode.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 214, 542, -14);
		panel_2.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 337, 542, 2);
		panel_2.add(separator_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 277, 578, 2);
		panel_1.add(separator);

		JList list = new JList();
		list.setBounds(437, 415, 1, 1);
		panel_1.add(list);

		JSpinner spinner = new JSpinner();
		spinner.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spinner.setBounds(453, 368, 59, 20);
		panel_1.add(spinner);

		JLabel lblStudent = new JLabel("");
		lblStudent.setBounds(10, 11, 214, 14);
		panel_1.add(lblStudent);

		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 265, 234, 14);
		panel_1.add(lblError);

		btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String ssn = textField_adminStudentSsn.getText();
					String name = textField_adminStudentName.getText();
					String address = textField_adminStudentAddress.getText();
					String email = textField_adminStudentEmail.getText();

					Student s = controller.getStudent(ssn);

					if (s == null) {

						boolean correct = controller.insertStudent(ssn, name, address, email);
						if (correct) {
							lblStudent.setText("Student added to the database.");
							textField_adminStudentSsn.setText("-");
							textField_adminStudentName.setText("-");
							textField_adminStudentAddress.setText("-");
							textField_adminStudentEmail.setText("-");

						} else {
							lblStudent.setText("Error.");
						}
					} else if (s != null) {
						lblStudent.setText("The student already exist.");

					}

				}

				catch (SQLException e1) {
					e1.printStackTrace();

				} catch (Exception e2) {
					e2.printStackTrace();

				}
			}
		});

		btnAddStudent.setBounds(10, 148, 100, 23);
		panel_1.add(btnAddStudent);

		JTextPane textPane_Student = new JTextPane();
		textPane_Student.setBounds(10, 204, 141, 62);
		panel_1.add(textPane_Student);

		btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textField_adminStudentSsn.getText();
				if (!"".equals(ssn)) {
					try {

						Student student = controller.getStudent(ssn);
						if (student != null) {
							String newSsn = student.getSsn();
							String name = student.getName();
							String address = student.getAddress();
							String email = student.getEmail();
							String wholeStudent = "Student ssn: " + newSsn + " Name: " + name + " Address: " + address
									+ " Email: " + email;

							textPane_Student.setText(wholeStudent);

						} else if (student == null) {
							lblStudent.setText("Student already exist.");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				} else {
					lblStudent.setText("You forgot the student ssn.");
				}
			}
		});
		btnFindStudent.setBounds(111, 148, 113, 23);
		panel_1.add(btnFindStudent);

		btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ssn = textField_adminStudentSsn.getText();

				if (!"".equals(ssn)) {
					try {
						boolean correct = controller.removeStudent(ssn);
						if (correct) {
							lblStudent.setText("Student with ssn " + ssn + " has been removed.");

						} else {
							lblStudent.setText("Wrong ssn.");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnRemoveStudent.setBounds(111, 168, 113, 23);
		panel_1.add(btnRemoveStudent);
	}
}