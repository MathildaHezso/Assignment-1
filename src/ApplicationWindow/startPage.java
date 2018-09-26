package ApplicationWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class startPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startPage window = new startPage();
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
	public startPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 161);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAssignment1 = new JButton("Assignment 1");
		btnAssignment1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppWindow app = new AppWindow(); 
				app.NewScreen();	
			}
		});
		btnAssignment1.setBounds(10, 47, 120, 23);
		frame.getContentPane().add(btnAssignment1);
		
		JButton btnAssignment2 = new JButton("Assignment 2");
		btnAssignment2.setBounds(158, 47, 120, 23);
		frame.getContentPane().add(btnAssignment2);
		
		JButton btnAssignment3 = new JButton("Assignment 3");
		btnAssignment3.setBounds(304, 47, 120, 23);
		frame.getContentPane().add(btnAssignment3);
	}


		
	}


