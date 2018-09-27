package ApplicationWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.List;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Component;

public class AppWindow {

	private JFrame frame;

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

	Connection con = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	/**
	 * Create the application.
	 */
	public AppWindow() {
		
		
		
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
		
		JPanel panel = new JPanel();
		tabbedPane_Assignment1.addTab("Overview", null, panel, null);
		panel.setLayout(null);
		
		JButton btnShowStudents = new JButton("Show All Students");
		btnShowStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowStudents.setBounds(118, 78, 140, 23);
		panel.add(btnShowStudents);
		
		JButton btnShowCourses = new JButton("Show All Courses");
		btnShowCourses.setBounds(295, 78, 140, 23);
		panel.add(btnShowCourses);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(41, 112, 482, 261);
		panel.add(textPane_5);
		
		JLabel lblOverview = new JLabel("OVERVIEW");
		lblOverview.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOverview.setBounds(236, 33, 80, 14);
		panel.add(lblOverview);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_Assignment1.addTab("Administration", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAddFind = new JLabel("Add / Find / Remove Student");
		lblAddFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind.setBounds(29, 30, 195, 14);
		panel_1.add(lblAddFind);
		
		JLabel lblAddFind_1 = new JLabel("Add / Find / Remove Course");
		lblAddFind_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind_1.setBounds(319, 30, 186, 14);
		panel_1.add(lblAddFind_1);
		
		textField = new JTextField();
		textField.setBounds(111, 55, 113, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 74, 113, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 98, 113, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 117, 113, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(392, 55, 113, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(392, 74, 113, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(392, 98, 113, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.setBounds(111, 148, 113, 23);
		panel_1.add(btnFindStudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.setBounds(111, 168, 113, 23);
		panel_1.add(btnRemoveStudent);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(10, 148, 100, 23);
		panel_1.add(btnAddStudent);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(392, 129, 113, 23);
		panel_1.add(btnFindCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(392, 148, 113, 23);
		panel_1.add(btnRemoveCourse);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(298, 129, 89, 23);
		panel_1.add(btnAddCourse);
		
		JLabel lblAddremoveStudentFrom = new JLabel("Add/Remove Student from Course");
		lblAddremoveStudentFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddremoveStudentFrom.setBounds(29, 290, 195, 14);
		panel_1.add(lblAddremoveStudentFrom);
		
		JLabel lblAddCompletedCourse = new JLabel("Add Completed Course");
		lblAddCompletedCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddCompletedCourse.setBounds(376, 290, 136, 14);
		panel_1.add(lblAddCompletedCourse);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 277, 578, 2);
		panel_1.add(separator);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 196, 214, 70);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(298, 182, 212, 84);
		panel_1.add(textPane_1);
		
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
		
		textField_10 = new JTextField();
		textField_10.setBounds(111, 345, 113, 20);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(111, 368, 113, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnShowGrade_1 = new JButton("Complete");
		btnShowGrade_1.setBounds(111, 399, 113, 23);
		panel_1.add(btnShowGrade_1);
		
		textField_12 = new JTextField();
		textField_12.setBounds(426, 326, 86, 20);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnComplete = new JButton("ADD");
		btnComplete.setActionCommand("");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComplete.setBounds(356, 399, 156, 23);
		panel_1.add(btnComplete);
		
		textField_13 = new JTextField();
		textField_13.setBounds(426, 345, 86, 20);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		JList list = new JList();
		list.setBounds(437, 415, 1, 1);
		panel_1.add(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spinner.setBounds(453, 368, 59, 20);
		panel_1.add(spinner);
		
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
		
		JRadioButton rdbtnAddStudies = new JRadioButton("Add Studies");
		rdbtnAddStudies.setBounds(32, 315, 89, 23);
		panel_1.add(rdbtnAddStudies);
		
		JRadioButton rdbtnRemoveStudies = new JRadioButton("Remove Studies");
		rdbtnRemoveStudies.setBounds(121, 315, 103, 23);
		panel_1.add(rdbtnRemoveStudies);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(24, 435, 488, 50);
		panel_1.add(textPane_2);
		
		JLabel label = new JLabel("*");
		label.setBounds(228, 348, 22, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setBounds(228, 371, 16, 14);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_Assignment1.addTab("Search", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblResultForCompleted = new JLabel("Student Resuts");
		lblResultForCompleted.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultForCompleted.setBounds(90, 25, 117, 14);
		panel_2.add(lblResultForCompleted);
		
		textField_7 = new JTextField();
		textField_7.setBounds(116, 66, 105, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(116, 94, 105, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(371, 64, 105, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnShowGrade = new JButton("Show grade");
		btnShowGrade.setBounds(116, 124, 105, 23);
		panel_2.add(btnShowGrade);
		
		JButton btnShowResult = new JButton("Show result");
		btnShowResult.setBounds(371, 91, 105, 23);
		panel_2.add(btnShowResult);
		
		JLabel lblCourseCode_3 = new JLabel("Course Code:");
		lblCourseCode_3.setBounds(293, 69, 79, 14);
		panel_2.add(lblCourseCode_3);
		
		JLabel lblStudentSsn_2 = new JLabel("Student SSN:");
		lblStudentSsn_2.setBounds(37, 69, 79, 14);
		panel_2.add(lblStudentSsn_2);
		
		JLabel lblCourseCode_4 = new JLabel("Course Code:");
		lblCourseCode_4.setBounds(37, 97, 88, 14);
		panel_2.add(lblCourseCode_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 214, 542, -14);
		panel_2.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 337, 542, 2);
		panel_2.add(separator_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(64, 173, 159, 153);
		panel_2.add(textPane_3);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(70, 155, 46, 14);
		panel_2.add(lblResult);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(309, 155, 167, 171);
		panel_2.add(textPane_4);
		
		JLabel lblCourseResults = new JLabel("Course Results");
		lblCourseResults.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourseResults.setBounds(354, 25, 86, 14);
		panel_2.add(lblCourseResults);
		
		JTabbedPane tabbedPane_Assignment2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 2", null, tabbedPane_Assignment2, null);
		
		JTabbedPane tabbedPane_Assignment3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 3", null, tabbedPane_Assignment3, null);
	}
}
