package CharitySoftware.Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import CharitySoftware.Classes.User;

import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jfMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpPrimaryContent;
	private static JFrame frame;
	
	private static Connection connection;
	private static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:sqlite:SQLite/CharityDB.db";
		
		try
		{
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("Connection Successful");
		
		}
		catch (SQLException e)
		{
		System.out.println("Can’t connect to the database!");
		e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jpRecord home = new jpRecord(connection);
					frame = new jfMain(home);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				//

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jfMain(JPanel panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Main Content Card Layout
		
		JPanel jpPrimaryContent = new JPanel();
		
		jpPrimaryContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(jpPrimaryContent, BorderLayout.CENTER);
		jpPrimaryContent.setLayout(new CardLayout(0, 0));
		
		jpRecord home = new jpRecord(connection);
		jpPrimaryContent.add(home, "home");
		
		jpTable table = new jpTable(connection);
		jpPrimaryContent.add(table, "table");
		
		jpEdit edit = new jpEdit(connection);
		jpPrimaryContent.add(edit, "edit");
		

		
		JPanel jpNavigation = new JPanel();
		jpNavigation.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(jpNavigation, BorderLayout.NORTH);
		
		JToolBar toolBar = new JToolBar();
		jpNavigation.add(toolBar);
		
		JLabel lblUsername = new JLabel("[username]");
		toolBar.add(lblUsername);
		
		JLabel lblDiv = new JLabel(" : ");
		toolBar.add(lblDiv);
		
		JLabel lblAccess = new JLabel("[access]");
		toolBar.add(lblAccess);
		
		JLabel lblMainDiv = new JLabel("  ||:||  ");
		toolBar.add(lblMainDiv);
		
		JButton btnLogout = new JButton("Log out");
		
		/*
		 * LOGOUT CLICKEVENT
		 */
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Logout Clicked");
				frame.dispose();
				awLogin Loginframe = new awLogin();
				Loginframe.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogout.setForeground(new Color(0, 0, 160));
		toolBar.add(btnLogout);
		
		JLabel lblDiv2 = new JLabel("  -  ");
		toolBar.add(lblDiv2);
		
		/*
		 * HOME PAGE CLICKEVENT
		 */
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(jpPrimaryContent.getLayout());
				cl.show(jpPrimaryContent, "home");
			}
			
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHome.setForeground(new Color(0, 0, 160));
		btnHome.setBackground(new Color(240, 240, 240));
		toolBar.add(btnHome);
		
		JLabel lblDiv3 = new JLabel("  -  ");
		toolBar.add(lblDiv3);
		
		/*
		 * STUDENT TABLE PAGE CLICKEVENT
		 */
		
		JButton btnAllStudents = new JButton("All Students");
		btnAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(jpPrimaryContent.getLayout());
				cl.show(jpPrimaryContent, "table");	
			}
		});
		btnAllStudents.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAllStudents.setForeground(new Color(0, 0, 160));
		toolBar.add(btnAllStudents);
		
		JLabel lblDiv4 = new JLabel("  -  ");
		toolBar.add(lblDiv4);
		/*
		 * EDIT PAGE CLICKEVENT
		 */
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(jpPrimaryContent.getLayout());
				cl.show(jpPrimaryContent, "edit");
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.setForeground(new Color(0, 0, 160));
		toolBar.add(btnEdit);
		
		JLabel lblDiv5 = new JLabel("  -  ");
		toolBar.add(lblDiv5);
		
		JButton btnViewRequests = new JButton("View Edit Requests");
		btnViewRequests.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewRequests.setForeground(new Color(0, 0, 160));
		toolBar.add(btnViewRequests);
	
	}
}
