package assignmentOne;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	private JTextField studentNameTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTextField ssnTextField;
	private JTextField courseCodeTextField;
	private JTextField courseNameTextField;
	private JTextField creditTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel studentTab = new JPanel();
		tabbedPane.addTab("Student", null, studentTab, null);
		studentTab.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Name");
		lblStudentName.setBounds(20, 66, 46, 14);
		studentTab.add(lblStudentName);
		
		studentNameTextField = new JTextField();
		studentNameTextField.setBounds(20, 80, 128, 20);
		studentTab.add(studentNameTextField);
		studentNameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(20, 122, 128, 20);
		studentTab.add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(20, 107, 61, 14);
		studentTab.add(lbladdress);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(20, 167, 128, 20);
		studentTab.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 153, 46, 14);
		studentTab.add(lblEmail);
		
		ssnTextField = new JTextField();
		ssnTextField.setBounds(20, 36, 128, 20);
		studentTab.add(ssnTextField);
		ssnTextField.setColumns(10);
		
		JLabel lblSsn = new JLabel("Ssn");
		lblSsn.setBounds(20, 22, 46, 14);
		studentTab.add(lblSsn);
		
		JButton btnAddStudent = new JButton("Add student");
		btnAddStudent.setBounds(20, 206, 128, 23);
		studentTab.add(btnAddStudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.setBounds(176, 206, 128, 23);
		studentTab.add(btnRemoveStudent);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(176, 36, 281, 151);
		studentTab.add(textArea);
		
		JButton btnFindStudent = new JButton("Find student(s)");
		btnFindStudent.setBounds(329, 206, 128, 23);
		studentTab.add(btnFindStudent);
		
		JPanel courseTab = new JPanel();
		tabbedPane.addTab("Course", null, courseTab, null);
		courseTab.setLayout(null);
		
		JLabel lblCourseCode = new JLabel("Course code");
		lblCourseCode.setBounds(20, 22, 100, 14);
		courseTab.add(lblCourseCode);
		
		courseCodeTextField = new JTextField();
		courseCodeTextField.setBounds(20, 37, 128, 20);
		courseTab.add(courseCodeTextField);
		courseCodeTextField.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setBounds(20, 66, 100, 14);
		courseTab.add(lblCourseName);
		
		courseNameTextField = new JTextField();
		courseNameTextField.setBounds(20, 80, 128, 20);
		courseTab.add(courseNameTextField);
		courseNameTextField.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(20, 107, 46, 14);
		courseTab.add(lblCredits);
		
		creditTextField = new JTextField();
		creditTextField.setBounds(20, 121, 128, 20);
		courseTab.add(creditTextField);
		creditTextField.setColumns(10);
		
		JButton btnAddCourse = new JButton("Add course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddCourse.setBounds(20, 206, 128, 23);
		courseTab.add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveCourse.setBounds(176, 206, 128, 23);
		courseTab.add(btnRemoveCourse);
		
		JButton btnFindCourse = new JButton("Find course(s)");
		btnFindCourse.setBounds(329, 206, 128, 23);
		courseTab.add(btnFindCourse);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(176, 36, 281, 151);
		courseTab.add(textArea_1);
		
		JPanel resultsTab = new JPanel();
		tabbedPane.addTab("Results", null, resultsTab, null);
	}
}
