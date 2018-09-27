package ApplicationWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import java.awt.List;
import java.awt.Label;
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
		frame.setBounds(100, 100, 649, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tabs
		
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
		
		JPanel panel_2 = new JPanel();
		tabbedPane_Assignment1.addTab("Search", null, panel_2, null);
		panel_2.setLayout(null);
		

		textField_7 = new JTextField();
		textField_7.setBounds(135, 66, 86, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(135, 94, 86, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(376, 65, 86, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		

		
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
		textPane_4.setBounds(318, 167, 165, 159);
		panel_2.add(textPane_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_Assignment1.addTab("Administration", null, panel_1, null);
		panel_1.setLayout(null);
	
		
		textField = new JTextField();
		textField.setBounds(111, 55, 133, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 86, 133, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 117, 133, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 149, 133, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(426, 55, 133, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(426, 86, 133, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(426, 117, 133, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		//Buttons
		
		JButton btnFindStudent = new JButton("Find");
		btnFindStudent.setBounds(185, 180, 59, 23);
		panel_1.add(btnFindStudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.setBounds(111, 214, 133, 23);
		panel_1.add(btnRemoveStudent);
		
		JButton btnAddStudent = new JButton("Add");
		btnAddStudent.setBounds(111, 180, 59, 23);
		panel_1.add(btnAddStudent);
		
		JButton btnFindCourse = new JButton("Find");
		btnFindCourse.setBounds(500, 180, 59, 23);
		panel_1.add(btnFindCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(426, 214, 133, 23);
		panel_1.add(btnRemoveCourse);
		
		JButton btnAddCourse = new JButton("Add");
		btnAddCourse.setBounds(426, 180, 59, 23);
		panel_1.add(btnAddCourse);
		
		JButton btnShowGrade = new JButton("Show grade");
		btnShowGrade.setBounds(132, 125, 89, 23);
		panel_2.add(btnShowGrade);
		
		JButton btnShowResult = new JButton("Show result");
		btnShowResult.setBounds(373, 96, 89, 23);
		panel_2.add(btnShowResult);
		
		JButton btnShowGrade_1 = new JButton("Complete");
		btnShowGrade_1.setBounds(424, 491, 135, 23);
		panel_1.add(btnShowGrade_1);
		
		JButton btnComplete = new JButton("ADD");
		btnComplete.setActionCommand("");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComplete.setBounds(111, 460, 133, 23);
		panel_1.add(btnComplete);
		
		JRadioButton rdbtnAddStudies = new JRadioButton("Add Studies");
		rdbtnAddStudies.setBounds(51, 369, 89, 23);
		panel_1.add(rdbtnAddStudies);
		
		JRadioButton rdbtnRemoveStudies = new JRadioButton("Remove Studies");
		rdbtnRemoveStudies.setBounds(141, 369, 103, 23);
		panel_1.add(rdbtnRemoveStudies);
	
		
		//Separator
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 331, 623, 6);
		panel_1.add(separator);
		
		//Text panes
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(51, 250, 214, 70);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(348, 250, 233, 70);
		panel_1.add(textPane_1);
		
		
		
		//Text fields
		
		textField_10 = new JTextField();
		textField_10.setBounds(111, 400, 133, 20);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(111, 429, 133, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		
		textField_12 = new JTextField();
		textField_12.setBounds(426, 400, 133, 20);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(426, 429, 133, 20);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		JList list = new JList();
		list.setBounds(437, 415, 1, 1);
		panel_1.add(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spinner.setBounds(500, 460, 59, 20);
		panel_1.add(spinner);
		
		//Labels
		
		JLabel lblGradeOnCourse = new JLabel("Grade on course:");
		lblGradeOnCourse.setBounds(348, 460, 87, 14);
		panel_1.add(lblGradeOnCourse);
		
		JLabel lblStudentSsn = new JLabel("Student SSN:");
		lblStudentSsn.setBounds(350, 403, 66, 14);
		panel_1.add(lblStudentSsn);
		
		JLabel lblCourseCode_1 = new JLabel("Course Code:");
		lblCourseCode_1.setBounds(348, 432, 68, 14);
		panel_1.add(lblCourseCode_1);
		
		JLabel lblStudentSsn_1 = new JLabel("* Student SSN:");
		lblStudentSsn_1.setBounds(37, 403, 81, 14);
		panel_1.add(lblStudentSsn_1);
		
		JLabel lblCourseCode_2 = new JLabel("Course Code:");
		lblCourseCode_2.setBounds(37, 432, 67, 14);
		panel_1.add(lblCourseCode_2);
		
		JLabel label = new JLabel("*");
		label.setBounds(243, 373, 22, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setBounds(130, 371, 16, 14);
		panel_1.add(label_1);
		
		JLabel lblAddremoveStudentFrom = new JLabel("Add/Remove Student from Course");
		lblAddremoveStudentFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddremoveStudentFrom.setBounds(51, 348, 195, 14);
		panel_1.add(lblAddremoveStudentFrom);
		
		JLabel lblAddCompletedCourse = new JLabel("Add Completed Course");
		lblAddCompletedCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddCompletedCourse.setBounds(336, 348, 136, 14);
		panel_1.add(lblAddCompletedCourse);
		
		JLabel lblResultForCompleted = new JLabel("Student results on Course:");
		lblResultForCompleted.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultForCompleted.setBounds(56, 25, 165, 14);
		panel_2.add(lblResultForCompleted);
		
		JLabel lblResultForCourse = new JLabel("RESULT for Course");
		lblResultForCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultForCourse.setBounds(327, 25, 135, 14);
		panel_2.add(lblResultForCourse);
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(51, 58, 46, 14);
		panel_1.add(lblSsn);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(51, 89, 46, 14);
		panel_1.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(51, 120, 46, 14);
		panel_1.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(51, 152, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblCourseCode = new JLabel("Course Code:");
		lblCourseCode.setBounds(348, 58, 68, 14);
		panel_1.add(lblCourseCode);
		
		JLabel lblCoureName = new JLabel("Course Name:");
		lblCoureName.setBounds(348, 89, 68, 14);
		panel_1.add(lblCoureName);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(348, 120, 46, 14);
		panel_1.add(lblCredits);
		
		JLabel lblAddFind = new JLabel("Add / Find / Remove Student");
		lblAddFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind.setBounds(51, 30, 173, 14);
		panel_1.add(lblAddFind);
		
		JLabel lblAddFind_1 = new JLabel("Add / Find / Remove Course");
		lblAddFind_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddFind_1.setBounds(336, 30, 176, 14);
		panel_1.add(lblAddFind_1);
		
		JLabel lblCourseCode_3 = new JLabel("Course Code:");
		lblCourseCode_3.setBounds(302, 68, 79, 14);
		panel_2.add(lblCourseCode_3);
		
		JLabel lblStudentSsn_2 = new JLabel("Student SSN:");
		lblStudentSsn_2.setBounds(52, 69, 64, 14);
		panel_2.add(lblStudentSsn_2);
		
		JLabel lblCourseCode_4 = new JLabel("Course Code:");
		lblCourseCode_4.setBounds(53, 97, 72, 14);
		panel_2.add(lblCourseCode_4);
		
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(51, 525, 530, 50);
		panel_1.add(textPane_2);
		
		
	}
}
