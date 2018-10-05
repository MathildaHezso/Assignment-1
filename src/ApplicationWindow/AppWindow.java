package ApplicationWindow;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import controller.Controller;
import model.Course;
import model.HasStudied;
import model.Student;
import model.Studies;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import assignment2.MetaDataDAL;
import java.awt.Desktop;
import java.io.IOException;

public class AppWindow {

	private JFrame frame;

	private MetaDataDAL metaDAL;
	private JButton btnShowCourses;
	private JButton btnShowStudents;
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
	private JTextField textField_adminHasStudiedSsn;
	private JTextField textField_adminHasStudiedCode;
	private JTable studentList;
	private JTable courseList;
	private JTextField textField_adminStudentCourseSsn;
	private JTextField textField_adminStudentCourseCode;

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
		metaDAL = new MetaDataDAL();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 572, 641);
		frame.getContentPane().add(tabbedPane);

		JTabbedPane tabbedPane_Assignment1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 1", null, tabbedPane_Assignment1, null);

		JPanel panel_assignment2 = new JPanel();
		tabbedPane.addTab("Assignment 2", null, panel_assignment2, null);
		panel_assignment2.setLayout(null);

		JTable table_assignment_2_1 = new JTable(new DefaultTableModel(new String[] {}, 0));
		table_assignment_2_1.setFont(new Font("Open Sans", Font.PLAIN, 11));
		JScrollPane scrollPane2 = new JScrollPane(table_assignment_2_1);
		panel_assignment2.add(scrollPane2);
		scrollPane2.setBounds(56, 106, 454, 150);

		JButton btnAllKeys = new JButton("All keys");
		btnAllKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					table_assignment_2_1.setModel(metaDAL.getAllKeys());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAllKeys.setBounds(56, 26, 106, 23);
		panel_assignment2.add(btnAllKeys);

		JButton btnShowAllIndex = new JButton("All index");
		btnShowAllIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_assignment_2_1.setModel(metaDAL.getAllIndexes());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowAllIndex.setBounds(174, 26, 106, 23);
		panel_assignment2.add(btnShowAllIndex);

		JButton btnAllConstraints = new JButton("All contraints");
		btnAllConstraints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					table_assignment_2_1.setModel(metaDAL.getAllConstraints());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnAllConstraints.setBounds(409, 26, 106, 23);
		panel_assignment2.add(btnAllConstraints);

		JButton btnAllTables = new JButton("All tables");
		btnAllTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table_assignment_2_1.setModel(metaDAL.getAllTables());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAllTables.setBounds(293, 26, 106, 23);
		panel_assignment2.add(btnAllTables);

		JButton btnEmpColumn = new JButton("Employee columns");
		btnEmpColumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_assignment_2_1.setModel(metaDAL.getAllEmpColumn());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpColumn.setBounds(86, 60, 203, 23);
		panel_assignment2.add(btnEmpColumn);

		JButton btnTableWithMost = new JButton("Table with most rows");
		btnTableWithMost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_assignment_2_1.setModel(metaDAL.getMostRows());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTableWithMost.setBounds(338, 60, 158, 23);
		panel_assignment2.add(btnTableWithMost);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(20, 291, 520, 2);
		panel_assignment2.add(separator_4);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(56, 411, 454, 150);
		panel_assignment2.add(scrollPane3);

		JTable table_EmpTables = new JTable();
		scrollPane3.setViewportView(table_EmpTables);
		scrollPane3.setBounds(56, 411, 454, 150);
		panel_assignment2.add(scrollPane3);

		JButton btnEmpTable = new JButton("Employee");
		btnEmpTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table_EmpTables.setModel(metaDAL.getEmployee());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpTable.setBounds(56, 318, 139, 23);
		panel_assignment2.add(btnEmpTable);

		JButton btnEmpAbsence = new JButton("Employee Absence");
		btnEmpAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_EmpTables.setModel(metaDAL.getEmployeeAbsence());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpAbsence.setBounds(56, 364, 139, 23);
		panel_assignment2.add(btnEmpAbsence);

		JButton btnEmpRelative = new JButton("Employee Relative");
		btnEmpRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_EmpTables.setModel(metaDAL.getEmployeeRelative());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpRelative.setBounds(218, 318, 139, 23);
		panel_assignment2.add(btnEmpRelative);

		JButton btnEmpQuali = new JButton("Employee qualification");
		btnEmpQuali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_EmpTables.setModel(metaDAL.getEmployeeQuali());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpQuali.setBounds(218, 364, 139, 23);
		panel_assignment2.add(btnEmpQuali);

		JButton btnEmpStatistic = new JButton("Employee statistics");
		btnEmpStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_EmpTables.setModel(metaDAL.getEmployeeStatistic());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpStatistic.setBounds(371, 318, 139, 23);
		panel_assignment2.add(btnEmpStatistic);

		JButton btnEmpPortal = new JButton("Employee Portal");
		btnEmpPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_EmpTables.setModel(metaDAL.getEmployeePortal());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmpPortal.setBounds(371, 364, 139, 23);
		panel_assignment2.add(btnEmpPortal);

		JPanel panel_overview = new JPanel();
		tabbedPane_Assignment1.addTab("Overview", null, panel_overview, null);
		panel_overview.setLayout(null);

		studentList = new JTable(new DefaultTableModel(new String[] { "Ssn", "Name", "Address", "Email" }, 0));
		studentList.setFont(new Font("Open Sans", Font.PLAIN, 11));
		JScrollPane studentListPane = new JScrollPane(studentList);
		panel_overview.add(studentListPane);
		studentListPane.setBounds(37, 103, 486, 123);

		// Shows all students in a JTable

		btnShowStudents = new JButton("Show All Students");
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
		panel_overview.add(btnShowStudents);

		courseList = new JTable(new DefaultTableModel(new String[] { "Course code", "Course code" }, 0));
		courseList.setFont(new Font("Open sans", Font.PLAIN, 11));
		JScrollPane courseListPane = new JScrollPane(courseList);
		panel_overview.add(courseListPane);
		courseListPane.setBounds(37, 334, 488, 123);

		// Shows all courses in the JTable
		btnShowCourses = new JButton("Show All Courses");
		btnShowCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					DefaultTableModel courseTable = (DefaultTableModel) courseList.getModel();
					courseTable.setRowCount(0);
					for (Course c : controller.getAllCourses()) {
						courseTable.addRow(new String[] { c.getCourseCode(), c.getCourseName() });
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnShowCourses.setBounds(37, 292, 486, 23);
		panel_overview.add(btnShowCourses);

		// Panel
		JLabel lblOverview = new JLabel("OVERVIEW");
		lblOverview.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOverview.setBounds(241, 21, 80, 14);
		panel_overview.add(lblOverview);

		JPanel panel_1 = new JPanel();
		tabbedPane_Assignment1.addTab("Administration", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		tabbedPane_Assignment1.addTab("Search", null, panel_2, null);
		panel_2.setLayout(null);

		// Label
		JLabel lblAddFind = new JLabel("Add / Find / Remove Student");
		lblAddFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind.setBounds(61, 30, 195, 14);
		panel_1.add(lblAddFind);

		JLabel lblAddFind_1 = new JLabel("Add / Find / Remove Course");
		lblAddFind_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind_1.setBounds(319, 30, 186, 14);
		panel_1.add(lblAddFind_1);

		JLabel lblAddremoveStudentFrom = new JLabel("Add/Remove Student from Course");
		lblAddremoveStudentFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddremoveStudentFrom.setBounds(61, 318, 195, 14);
		panel_1.add(lblAddremoveStudentFrom);

		JLabel lblAddCompletedCourse = new JLabel("Add Completed Course");
		lblAddCompletedCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddCompletedCourse.setBounds(369, 318, 136, 14);
		panel_1.add(lblAddCompletedCourse);

		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(51, 55, 46, 14);
		panel_1.add(lblSsn);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(51, 76, 46, 14);
		panel_1.add(lblName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(51, 101, 103, 14);
		panel_1.add(lblAddress);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(51, 120, 46, 14);
		panel_1.add(lblEmail);

		JLabel lblCourseCode = new JLabel("Course Code:");
		lblCourseCode.setBounds(297, 58, 85, 14);
		panel_1.add(lblCourseCode);

		JLabel lblCoureName = new JLabel("Course Name:");
		lblCoureName.setBounds(297, 76, 93, 14);
		panel_1.add(lblCoureName);

		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(297, 101, 46, 14);
		panel_1.add(lblCredits);

		JLabel lblGradeOnCourse = new JLabel("Grade on course:");
		lblGradeOnCourse.setBounds(297, 399, 120, 14);
		panel_1.add(lblGradeOnCourse);

		JLabel lblStudentSsn = new JLabel("Student SSN:");
		lblStudentSsn.setBounds(295, 351, 87, 14);
		panel_1.add(lblStudentSsn);

		JLabel lblCourseCode_1 = new JLabel("Course Code:");
		lblCourseCode_1.setBounds(297, 376, 87, 14);
		panel_1.add(lblCourseCode_1);

		JLabel lblStudentSsn_AddRemove = new JLabel("* Student SSN:");
		lblStudentSsn_AddRemove.setBounds(10, 351, 81, 14);
		panel_1.add(lblStudentSsn_AddRemove);

		JLabel lblCourseCode_AddRemove = new JLabel("* Course Code: ");
		lblCourseCode_AddRemove.setBounds(10, 376, 93, 14);
		panel_1.add(lblCourseCode_AddRemove);

		JLabel lblResultForCompleted = new JLabel("Student Results");
		lblResultForCompleted.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultForCompleted.setBounds(232, 22, 117, 14);
		panel_2.add(lblResultForCompleted);

		JLabel lblCourseCode_3 = new JLabel("Course Code:");
		lblCourseCode_3.setBounds(115, 347, 79, 14);
		panel_2.add(lblCourseCode_3);

		JLabel lblStudentSsn_2 = new JLabel("Student SSN:");
		lblStudentSsn_2.setBounds(115, 50, 106, 14);
		panel_2.add(lblStudentSsn_2);

		JLabel lblCourseCode_4 = new JLabel("Course Code:");
		lblCourseCode_4.setBounds(115, 78, 105, 14);
		panel_2.add(lblCourseCode_4);

		JLabel lblCourseResults = new JLabel("Course Results");
		lblCourseResults.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourseResults.setBounds(232, 319, 86, 14);
		panel_2.add(lblCourseResults);

		JLabel lblAddRemoveStudentCourse = new JLabel("X");
		lblAddRemoveStudentCourse.setBounds(25, 463, 262, 14);
		panel_1.add(lblAddRemoveStudentCourse);

		JLabel lblCourse = new JLabel("X");
		lblCourse.setBounds(319, 205, 233, 14);
		panel_1.add(lblCourse);

		JLabel lblCompletedCourse = new JLabel("X");
		lblCompletedCourse.setBounds(297, 463, 255, 14);
		panel_1.add(lblCompletedCourse);

		JLabel lblStudent = new JLabel("X");
		lblStudent.setBounds(27, 205, 246, 14);
		panel_1.add(lblStudent);

		JLabel lblStudentResults = new JLabel("X");
		lblStudentResults.setBounds(115, 136, 328, 14);
		panel_2.add(lblStudentResults);

		// Text Panes
		JTextPane textPane_Student = new JTextPane();
		textPane_Student.setBounds(26, 230, 218, 62);
		panel_1.add(textPane_Student);

		JTextPane textPane_Course = new JTextPane();
		textPane_Course.setBounds(319, 230, 213, 62);
		panel_1.add(textPane_Course);

		// Text Fields
		textField_adminStudentSsn = new JTextField();
		textField_adminStudentSsn.setBounds(104, 55, 140, 20);
		panel_1.add(textField_adminStudentSsn);
		textField_adminStudentSsn.setColumns(10);

		textField_adminStudentName = new JTextField();
		textField_adminStudentName.setBounds(104, 74, 140, 20);
		panel_1.add(textField_adminStudentName);
		textField_adminStudentName.setColumns(10);

		textField_adminStudentAddress = new JTextField();
		textField_adminStudentAddress.setBounds(104, 98, 140, 20);
		panel_1.add(textField_adminStudentAddress);
		textField_adminStudentAddress.setColumns(10);

		textField_adminStudentEmail = new JTextField();
		textField_adminStudentEmail.setBounds(104, 117, 140, 20);
		panel_1.add(textField_adminStudentEmail);
		textField_adminStudentEmail.setColumns(10);

		textField_adminCourseCode = new JTextField();
		textField_adminCourseCode.setBounds(392, 55, 140, 20);
		panel_1.add(textField_adminCourseCode);
		textField_adminCourseCode.setColumns(10);

		textField_adminCourseName = new JTextField();
		textField_adminCourseName.setBounds(392, 74, 140, 20);
		panel_1.add(textField_adminCourseName);
		textField_adminCourseName.setColumns(10);

		textField_adminCourseCredits = new JTextField();
		textField_adminCourseCredits.setBounds(392, 98, 140, 20);
		panel_1.add(textField_adminCourseCredits);
		textField_adminCourseCredits.setColumns(10);

		textField_adminHasStudiedSsn = new JTextField();
		textField_adminHasStudiedSsn.setBounds(394, 351, 138, 20);
		panel_1.add(textField_adminHasStudiedSsn);
		textField_adminHasStudiedSsn.setColumns(10);

		textField_adminHasStudiedCode = new JTextField();
		textField_adminHasStudiedCode.setBounds(394, 373, 138, 20);
		panel_1.add(textField_adminHasStudiedCode);
		textField_adminHasStudiedCode.setColumns(10);

		textField_adminStudentCourseSsn = new JTextField();
		textField_adminStudentCourseSsn.setBounds(104, 348, 140, 20);
		panel_1.add(textField_adminStudentCourseSsn);
		textField_adminStudentCourseSsn.setColumns(10);

		textField_adminStudentCourseCode = new JTextField();
		textField_adminStudentCourseCode.setBounds(104, 373, 140, 20);
		panel_1.add(textField_adminStudentCourseCode);
		textField_adminStudentCourseCode.setColumns(10);

		// Separators
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 305, 578, 2);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 214, 542, -14);
		panel_2.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 287, 572, 2);
		panel_2.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 259, 562, 2);
		panel_overview.add(separator_3);

		// Combo Boxes
		JComboBox<String> comboBoxGrade = new JComboBox<String>();
		comboBoxGrade.setBounds(464, 396, 68, 20);
		panel_1.add(comboBoxGrade);
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("F");

		JComboBox<String> comboBoxAllCourses = new JComboBox<String>();
		comboBoxAllCourses.setBounds(209, 344, 140, 20);
		panel_2.add(comboBoxAllCourses);
		try {
			for (Course c : controller.getAllCourses()) {
				comboBoxAllCourses.addItem(c.getCourseCode());
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JComboBox<String> comboBoxAllStudent = new JComboBox<String>();
		comboBoxAllStudent.setBounds(209, 47, 140, 20);
		panel_2.add(comboBoxAllStudent);
		try {
			for (Student s : controller.getAllStudents()) {
				comboBoxAllStudent.addItem(s.getSsn());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JComboBox<String> comboBoxAllCoursesStudent = new JComboBox<String>();
		comboBoxAllCoursesStudent.setBounds(209, 75, 140, 20);
		panel_2.add(comboBoxAllCoursesStudent);
		try {
			for (Course c : controller.getAllCourses()) {
				comboBoxAllCoursesStudent.addItem(c.getCourseCode());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// Adds a student to the database
		btnAddStudent = new JButton("Add ");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBoxAllStudent.removeAllItems();
				try {

					String ssn = textField_adminStudentSsn.getText();
					String name = textField_adminStudentName.getText();
					String address = textField_adminStudentAddress.getText();
					String email = textField_adminStudentEmail.getText();

					Student s = controller.getStudent(ssn);

					if (ssn.isEmpty() || name.isEmpty() || address.isEmpty() || email.isEmpty()) {
						lblStudent.setText("Please fill out all fields.");
					}

					else if (s == null) {

						boolean correct = controller.insertStudent(ssn, name, address, email);
						if (correct) {
							lblStudent.setText("Student added to the database.");
							textField_adminStudentSsn.setText("");
							textField_adminStudentName.setText("");
							textField_adminStudentAddress.setText("");
							textField_adminStudentEmail.setText("");

							try {

								for (Student st : controller.getAllStudents()) {
									comboBoxAllStudent.addItem(st.getSsn());

								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

					} else if (s != null) {
						lblStudent.setText("The student already exist.");

					} else {
						lblStudent.setText("Error.");
					}

				}

				catch (SQLException e1) {
					e1.printStackTrace();

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});

		btnAddStudent.setBounds(105, 148, 68, 23);
		panel_1.add(btnAddStudent);

		// Find a student
		btnFindStudent = new JButton("Find ");
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
							lblStudent.setText("Student does not yet exist.");
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
		btnFindStudent.setBounds(176, 148, 68, 23);
		panel_1.add(btnFindStudent);

		// Removes a student from the database
		btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String removeSsn = textField_adminStudentSsn.getText();

				if (textField_adminStudentSsn.getText().isEmpty()) {
					lblStudent.setText("Please fill out the student ssn.");

				} else if (!"".equals(removeSsn)) {
					try {
						boolean correct = controller.removeStudent(removeSsn);
						if (correct) {
							lblStudent.setText("Student with ssn " + removeSsn + " has been removed.");
							textField_adminStudentSsn.setText("");

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
		btnRemoveStudent.setBounds(105, 172, 139, 23);
		panel_1.add(btnRemoveStudent);

		// Adds a course to the database
		JButton btnAddCourse = new JButton("Add");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBoxAllCoursesStudent.removeAllItems();
				comboBoxAllCourses.removeAllItems();
				try {

					String courseCode = textField_adminCourseCode.getText();
					String courseName = textField_adminCourseName.getText();
					String credits = textField_adminCourseCredits.getText();

					Course c = controller.getCourse(courseCode);

					if (courseCode.isEmpty() || courseName.isEmpty() || credits.isEmpty()) {
						lblCourse.setText("Please fill out all fields.");

					}

					else if (c == null) {
						int convertCredits = Integer.parseInt(credits);
						boolean correct = controller.insertCourse(courseCode, courseName, convertCredits);
						if (correct) {
							lblCourse.setText("Course added to the database.");
							textField_adminCourseCode.setText("");
							textField_adminCourseName.setText("");
							textField_adminCourseCredits.setText("");

							try {
								for (Course course : controller.getAllCourses()) {
									comboBoxAllCourses.addItem(course.getCourseCode());
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}

							try {
								for (Course course : controller.getAllCourses()) {
									comboBoxAllCoursesStudent.addItem(course.getCourseCode());
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}

						} else {
							lblCourse.setText("Error.");
						}
					} else if (c != null) {
						lblCourse.setText("The course already exist.");

					}

				}

				catch (NumberFormatException e1) {
					lblCourse.setText("Credits can only be numbers.");

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}

		});

		btnAddCourse.setBounds(392, 148, 68, 23);
		panel_1.add(btnAddCourse);

		// Find a course
		JButton btnFindCourse = new JButton("Find");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String courseCode = textField_adminCourseCode.getText();
				if (!"".equals(courseCode)) {
					try {

						Course course = controller.getCourse(courseCode);
						if (course != null) {
							String cCode = course.getCourseCode();
							String courseName = course.getCourseName();
							int credit = course.getCredit();
							String wholeCourse = "Course code: " + cCode + " Course name: " + courseName + " Credits: "
									+ credit;

							textPane_Course.setText(wholeCourse);

						} else if (course == null) {
							lblCourse.setText("Course doesn't exist.");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				} else {
					lblCourse.setText("You forgot the course code.");
				}

			}
		});

		btnFindCourse.setBounds(464, 148, 68, 23);
		panel_1.add(btnFindCourse);

		// Remove a student from the database
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String removeCourseCode = textField_adminCourseCode.getText();

				if (!"".equals(removeCourseCode)) {
					try {
						boolean correct = controller.removeCourse(removeCourseCode);
						if (correct) {
							lblCourse.setText("Course with course code " + removeCourseCode + " has been removed.");
						} else {
							lblCourse.setText("Wrong course code.");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					lblCourse.setText("Please fill out the course code.");
				}

			}
		});

		btnRemoveCourse.setBounds(392, 172, 140, 23);
		panel_1.add(btnRemoveCourse);

		// Add a student to a finished course and chose a grade
		JButton btnAddStudentCourse = new JButton("Add");
		btnAddStudentCourse.setActionCommand("");
		btnAddStudentCourse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {

					String studentSsn = textField_adminHasStudiedSsn.getText();
					String courseCode = textField_adminHasStudiedCode.getText();
					String grade = comboBoxGrade.getSelectedItem().toString();

					Student s = controller.getStudent(studentSsn);
					Course c = controller.getCourse(courseCode);
					HasStudied hs = controller.getHasStudied(studentSsn, courseCode);
					Studies st = controller.getAllStudies(studentSsn, courseCode);

					if (studentSsn.isEmpty() || courseCode.isEmpty()) {
						lblCompletedCourse.setText("Please fill out all fields.");

					} else if (s == null) {
						lblCompletedCourse.setText("The student does not exist.");
					} else if (c == null) {
						lblCompletedCourse.setText("The course does not exist.");
					} else if (st == null) {
						lblCompletedCourse.setText("Student does not study this course.");
					} else if (hs != null) {
						lblCompletedCourse.setText("The student has already studied this course.");
					} else if (hs == null) {
						boolean correct = controller.insertHasStudied(studentSsn, courseCode, grade);
						if (correct) {
							lblCompletedCourse.setText(studentSsn + " registered on " + courseCode);
						}
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnAddStudentCourse.setBounds(392, 421, 140, 23);
		panel_1.add(btnAddStudentCourse);

		// Add student to a current course
		JButton btnAddStudentsOnCourse = new JButton("Add");
		btnAddStudentsOnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String studentSsn = textField_adminStudentCourseSsn.getText();
					String courseCode = textField_adminStudentCourseCode.getText();

					Student st = controller.getStudent(studentSsn);
					Studies s = controller.getAllStudies(studentSsn, courseCode);
					Course c = controller.getCourse(courseCode);

					if (studentSsn.isEmpty() || courseCode.isEmpty()) {
						lblAddRemoveStudentCourse.setText("Please fill out both text fields.");
					} else if (st == null) {
						lblAddRemoveStudentCourse.setText("The student does not exist.");
					} else if (c == null) {
						lblAddRemoveStudentCourse.setText("The course does not exist.");
					} else if (s == null) {
						boolean correct = controller.insertStudies(studentSsn, courseCode);
						if (correct) {
							lblAddRemoveStudentCourse
									.setText("Student " + studentSsn + " added to course " + courseCode);
							textField_adminStudentCourseSsn.setText("");
							textField_adminStudentCourseCode.setText("");

						}
					} else if (s != null) {
						lblAddRemoveStudentCourse.setText("Student already studying on this course.");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnAddStudentsOnCourse.setBounds(104, 405, 140, 23);
		panel_1.add(btnAddStudentsOnCourse);

		// Remove a student from a course
		JButton btnRemoveStudentCourse = new JButton("Remove");
		btnRemoveStudentCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String removeSsn = textField_adminStudentCourseSsn.getText();
					String removeCourseCode = textField_adminStudentCourseCode.getText();

					Student st = controller.getStudent(removeSsn);

					Course c = controller.getCourse(removeCourseCode);
					Studies s = controller.getAllStudies(removeSsn, removeCourseCode);
					if (removeSsn.isEmpty() || removeCourseCode.isEmpty()) {
						lblAddRemoveStudentCourse.setText("Please fill out both fields.");
					} else if (st == null) {
						lblAddRemoveStudentCourse.setText("Student does not exist.");
					} else if (c == null) {
						lblAddRemoveStudentCourse.setText("Course does not exist.");
					} else if (s == null) {
						lblAddRemoveStudentCourse.setText("The student does not study this course.");
					} else if (s != null) {
						boolean correct = controller.removeStudies(removeSsn, removeCourseCode);
						if (correct) {
							lblAddRemoveStudentCourse
									.setText("Student with ssn " + removeSsn + " has been removed from course.");
							textField_adminStudentCourseSsn.setText("");
							textField_adminStudentCourseCode.setText("");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}

		});
		btnRemoveStudentCourse.setBounds(104, 429, 140, 23);
		panel_1.add(btnRemoveStudentCourse);

		// Shows all students who are currently studying on a course in a JTable
		JTable studentCourseList = new JTable(new DefaultTableModel(new String[] { "Ssn", "Course code" }, 0));
		studentCourseList.setFont(new Font("Open Sans", Font.PLAIN, 11));
		JScrollPane studentCourseListPane = new JScrollPane(studentCourseList);
		panel_1.add(studentCourseListPane);
		studentCourseListPane.setBounds(26, 482, 506, 56);

		JButton btnShowAllStudentsOnAllCourses = new JButton("Show all students currently studying");
		btnShowAllStudentsOnAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					DefaultTableModel studentCourseTable = (DefaultTableModel) studentCourseList.getModel();
					studentCourseTable.setRowCount(0);
					for (Studies s : controller.getAllStudies()) {
						studentCourseTable.addRow(new String[] { s.getStudentSsn(), s.getCourseCode() });
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		btnShowAllStudentsOnAllCourses.setBounds(26, 549, 506, 23);
		panel_1.add(btnShowAllStudentsOnAllCourses);

		JTable showGradeList = new JTable(new DefaultTableModel(new String[] { "Ssn", "Course code", "Grade" }, 0));
		showGradeList.setFont(new Font("Open Sans", Font.PLAIN, 11));
		JScrollPane showGradeListPane = new JScrollPane(showGradeList);
		panel_2.add(showGradeListPane);
		showGradeListPane.setBounds(30, 161, 501, 97);

		// Shows the grade for a student on a certain course
		JButton btnShowGrade = new JButton("Show grade");
		btnShowGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String studentSsn = comboBoxAllStudent.getSelectedItem().toString();
					String courseCode = comboBoxAllCoursesStudent.getSelectedItem().toString();

					HasStudied hasStudied = controller.getHasStudied(studentSsn, courseCode);

					if (hasStudied == null) {
						lblStudentResults.setText("This student has not studied this course.");

					}
					DefaultTableModel studentGradeTable = (DefaultTableModel) showGradeList.getModel();
					studentGradeTable.setRowCount(0);
					for (HasStudied hs : controller.getAllStudied(studentSsn, courseCode)) {
						studentGradeTable
								.addRow(new String[] { hs.getStudentSsn(), hs.getCourseCode(), hs.getGrade() });
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnShowGrade.setBounds(209, 103, 140, 23);
		panel_2.add(btnShowGrade);

		JTable showAllCourseList = new JTable(new DefaultTableModel(new String[] { "Ssn", "Course code", "Grade" }, 0));
		showAllCourseList.setFont(new Font("Open Sans", Font.PLAIN, 11));
		JScrollPane showAllCourseListPane = new JScrollPane(showAllCourseList);
		panel_2.add(showAllCourseListPane);
		showAllCourseListPane.setBounds(30, 426, 501, 97);

		// Show result for a finished course
		JButton btnShowResult = new JButton("Show result");
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = comboBoxAllCourses.getSelectedItem().toString();

				try {

					if (courseCode != null) {
						// lbl
					}
					DefaultTableModel courseResultTable = (DefaultTableModel) showAllCourseList.getModel();
					courseResultTable.setRowCount(0);
					for (HasStudied hs : controller.getAllHasStudied(courseCode)) {
						courseResultTable
								.addRow(new String[] { hs.getStudentSsn(), hs.getCourseCode(), hs.getGrade() });
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnShowResult.setBounds(209, 375, 140, 23);
		panel_2.add(btnShowResult);
		
		JPanel panel_assignment3 = new JPanel();
		tabbedPane.addTab("Assignment 3", null, panel_assignment3, null);
		panel_assignment3.setLayout(null);
		
		JButton btnOpenExcel = new JButton("Report of All Customers");
		btnOpenExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Users\\Administrator\\Desktop\\AllCustomers.docx");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnOpenExcel.setBounds(217, 176, 170, 23);
		panel_assignment3.add(btnOpenExcel);
		
		JButton btnNewButton = new JButton("Report of All Employees");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Users\\Administrator\\Desktop\\AllEmployees.docx");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(217, 215, 170, 23);
		panel_assignment3.add(btnNewButton);
		
		JLabel lblExcel = new JLabel("Open Queries & Reports in:");
		lblExcel.setBounds(54, 50, 170, 14);
		panel_assignment3.add(lblExcel);
		
		JLabel lblMicrosoftWord = new JLabel("In Microsoft Word, open:");
		lblMicrosoftWord.setBounds(54, 180, 144, 14);
		panel_assignment3.add(lblMicrosoftWord);
		
		JButton btnNewButton_1 = new JButton("Microsoft Excel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Users\\Administrator\\Desktop\\Assignment3.xlsx");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(217, 46, 151, 23);
		panel_assignment3.add(btnNewButton_1);
		
		JButton btnQueriesReports = new JButton("Microsoft Access");
		btnQueriesReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\\\Users\\\\Administrator\\\\Desktop\\\\Assignment3.accdb");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnQueriesReports.setBounds(217, 80, 151, 23);
		panel_assignment3.add(btnQueriesReports);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 140, 547, 7);
		panel_assignment3.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 336, 547, 0);
		panel_assignment3.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 324, 547, 14);
		panel_assignment3.add(separator_7);

	}
}