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
		
		JPanel panel_1 = new JPanel();
		tabbedPane_Assignment1.addTab("Add/find/remove", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAddFind = new JLabel("Add / FInd / Delete Student");
		lblAddFind.setBounds(51, 30, 149, 14);
		panel_1.add(lblAddFind);
		
		JLabel lblAddFind_1 = new JLabel("Add / Find / Delete Course");
		lblAddFind_1.setBounds(356, 30, 149, 14);
		panel_1.add(lblAddFind_1);
		
		textField = new JTextField();
		textField.setBounds(114, 55, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 86, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 117, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 148, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(402, 55, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(402, 86, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(402, 117, 86, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.setBounds(103, 179, 100, 23);
		panel_1.add(btnFindStudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.setBounds(90, 213, 113, 23);
		panel_1.add(btnRemoveStudent);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(1, 179, 100, 23);
		panel_1.add(btnAddStudent);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(399, 179, 89, 23);
		panel_1.add(btnFindCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(392, 213, 113, 23);
		panel_1.add(btnRemoveCourse);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(298, 179, 89, 23);
		panel_1.add(btnAddCourse);
		
		JLabel lblAddremoveStudentFrom = new JLabel("Add/Remove Student from Course");
		lblAddremoveStudentFrom.setBounds(39, 298, 165, 14);
		panel_1.add(lblAddremoveStudentFrom);
		
		JLabel lblAddCompletedCourse = new JLabel("Add Completed Course");
		lblAddCompletedCourse.setBounds(369, 298, 119, 14);
		panel_1.add(lblAddCompletedCourse);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_Assignment1.addTab("Search", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_Assignment2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 2", null, tabbedPane_Assignment2, null);
		
		JTabbedPane tabbedPane_Assignment3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Assignment 3", null, tabbedPane_Assignment3, null);
	}
}
