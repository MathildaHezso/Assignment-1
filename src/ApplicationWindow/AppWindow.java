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

public class AppWindow {

	private JFrame frame;
	private JTextField ssnTextField;
	private JTextField nameTextFiled;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTable table;
	private JTable tableStudentsAndCourses;
	private JTable table_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_3;

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
		
		JPanel directoryTab = new JPanel();
		tabbedPane.addTab("Directory", null, directoryTab, null);
		directoryTab.setLayout(null);
		
		JButton btnShowStudents = new JButton("Show Student(s)");
		btnShowStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowStudents.setBounds(31, 29, 236, 23);
		directoryTab.add(btnShowStudents);
		
		JButton btnSowCourses = new JButton("Show course(s)");
		btnSowCourses.setBounds(303, 29, 236, 23);
		directoryTab.add(btnSowCourses);
		
		tableStudentsAndCourses = new JTable();
		tableStudentsAndCourses.setBounds(31, 86, 508, 156);
		directoryTab.add(tableStudentsAndCourses);
		
		JPanel studentsTab = new JPanel();
		tabbedPane.addTab("Students", null, studentsTab, null);
		studentsTab.setLayout(null);
		
		JLabel lblSsn = new JLabel("Ssn");
		lblSsn.setBounds(19, 21, 46, 14);
		studentsTab.add(lblSsn);
		
		ssnTextField = new JTextField();
		ssnTextField.setBounds(71, 18, 441, 20);
		studentsTab.add(ssnTextField);
		ssnTextField.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Name");
		lblStudentName.setBounds(19, 86, 46, 14);
		studentsTab.add(lblStudentName);
		
		nameTextFiled = new JTextField();
		nameTextFiled.setBounds(71, 83, 441, 20);
		studentsTab.add(nameTextFiled);
		nameTextFiled.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(71, 114, 441, 20);
		studentsTab.add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lblStudentAddress = new JLabel("Address");
		lblStudentAddress.setBounds(19, 117, 46, 14);
		studentsTab.add(lblStudentAddress);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(71, 145, 441, 20);
		studentsTab.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(19, 148, 46, 14);
		studentsTab.add(lblEmail);
		
		table = new JTable();
		table.setBounds(71, 405, 441, 80);
		studentsTab.add(table);
		
		table_2 = new JTable();
		table_2.setBounds(71, 238, 441, 80);
		studentsTab.add(table_2);
		
		JButton btnAddStudent = new JButton("Add student");
		btnAddStudent.setBounds(71, 176, 441, 23);
		studentsTab.add(btnAddStudent);
		
		JButton btnRemoveStudent = new JButton("Remove student");
		btnRemoveStudent.setBounds(313, 49, 199, 23);
		studentsTab.add(btnRemoveStudent);
		
		JButton btnFindStudent = new JButton("Find student");
		btnFindStudent.setBounds(70, 49, 199, 23);
		studentsTab.add(btnFindStudent);
		
		JLabel lblExistingStudents = new JLabel("Existing students");
		lblExistingStudents.setBounds(71, 224, 132, 14);
		studentsTab.add(lblExistingStudents);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 336, 577, 12);
		studentsTab.add(separator);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setBounds(19, 380, 46, 14);
		studentsTab.add(lblCourses);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(484, 359, 28, 20);
		studentsTab.add(comboBox);
		
		JPanel coursesTab = new JPanel();
		tabbedPane.addTab("Courses", null, coursesTab, null);
		coursesTab.setLayout(null);
		
		JLabel lblCourseCode = new JLabel("Course code");
		lblCourseCode.setBounds(19, 21, 73, 14);
		coursesTab.add(lblCourseCode);
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 18, 356, 20);
		coursesTab.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(88, 49, 356, 20);
		coursesTab.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setBounds(19, 52, 84, 14);
		coursesTab.add(lblCourseName);
		
		textField_6 = new JTextField();
		textField_6.setBounds(88, 80, 356, 20);
		coursesTab.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCourseCredits = new JLabel("Credits");
		lblCourseCredits.setBounds(19, 83, 46, 14);
		coursesTab.add(lblCourseCredits);
		
		table_3 = new JTable();
		table_3.setBounds(19, 124, 524, 84);
		coursesTab.add(table_3);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(454, 17, 89, 23);
		coursesTab.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(454, 48, 89, 23);
		coursesTab.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(454, 79, 89, 23);
		coursesTab.add(btnNewButton_7);
	}
}
