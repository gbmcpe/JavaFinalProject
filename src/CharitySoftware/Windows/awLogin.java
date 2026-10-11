package CharitySoftware.Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class awLogin {

	private JFrame frame;
	private JTextField txtfUser;
	private JPasswordField pwdfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					awLogin window = new awLogin();
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
	public awLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("New button");
		
		
		/**
		 * Login ClickEvent
		 */
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Login Clicked");
				frame.dispose();
				///jpRecord home = new jpRecord();
				//jfMain mainFrame= new jfMain(home);
				//mainFrame.setVisible(true);
			}
		});
		btnLogin.setBounds(170, 183, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		txtfUser = new JTextField();
		txtfUser.setBounds(170, 121, 86, 20);
		frame.getContentPane().add(txtfUser);
		txtfUser.setColumns(10);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setBounds(81, 124, 58, 14);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(81, 155, 58, 14);
		frame.getContentPane().add(lblPassword);
		
		pwdfPassword = new JPasswordField();
		pwdfPassword.setBounds(170, 152, 86, 20);
		frame.getContentPane().add(pwdfPassword);
	}
}
