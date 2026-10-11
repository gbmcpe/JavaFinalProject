package CharitySoftware.Windows;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class jpEdit extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtfMajor;
	private JTextField txtfEmail;
	private JTextField txtfPhone;
	
	
	
	private Connection conn;

	/**
	 * Create the panel.
	 */
	public jpEdit(Connection dbconn) {
		
		conn = dbconn;
		setLayout(null);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBackground(new Color(128, 128, 128));
		lblPicture.setBounds(202, 355, 150, 151);
		add(lblPicture);
		
		JLabel lblTitle = new JLabel("Editing Record for [student name]");
		lblTitle.setBounds(200, 29, 238, 27);
		add(lblTitle);
		
		JTextArea taBio = new JTextArea();
		taBio.setEditable(false);
		taBio.setBounds(197, 177, 276, 140);
		add(taBio);
		
		JButton btnNewButton = new JButton("Browse files...");
		btnNewButton.setBounds(362, 468, 111, 23);
		add(btnNewButton);
		
		JLabel lblCurrentPicture = new JLabel("Picture:");
		lblCurrentPicture.setBounds(65, 417, 97, 27);
		add(lblCurrentPicture);
		
		JLabel lblBio = new JLabel("Biography");
		lblBio.setBounds(65, 200, 56, 14);
		add(lblBio);
		
		JLabel lblMajor = new JLabel("Major/Interest:");
		lblMajor.setBounds(65, 61, 97, 27);
		add(lblMajor);
		
		JButton btnEditResetMaj = new JButton("Edit");
		btnEditResetMaj.setBounds(380, 63, 85, 23);
		add(btnEditResetMaj);
		
		txtfMajor = new JTextField();
		txtfMajor.setEditable(false);
		txtfMajor.setBounds(197, 64, 161, 20);
		add(txtfMajor);
		txtfMajor.setColumns(10);
		
		txtfEmail = new JTextField();
		txtfEmail.setEditable(false);
		txtfEmail.setColumns(10);
		txtfEmail.setBounds(197, 103, 161, 20);
		add(txtfEmail);
		
		JLabel lblEmail = new JLabel("Email Address:");
		lblEmail.setBounds(65, 100, 97, 27);
		add(lblEmail);
		
		JLabel lblPhoneNum = new JLabel("Phone Number:");
		lblPhoneNum.setBounds(65, 138, 97, 27);
		add(lblPhoneNum);
		
		txtfPhone = new JTextField();
		txtfPhone.setEditable(false);
		txtfPhone.setColumns(10);
		txtfPhone.setBounds(197, 146, 161, 20);
		add(txtfPhone);
		
		JButton btnEditResetEmail = new JButton("Edit");
		btnEditResetEmail.setBounds(380, 102, 85, 23);
		add(btnEditResetEmail);
		
		JButton btnSubmit = new JButton("Submit Changes");
		btnSubmit.setBounds(224, 529, 128, 23);
		add(btnSubmit);
		
		JButton btnEditResetPhone = new JButton("Edit");
		btnEditResetPhone.setBounds(380, 143, 85, 23);
		add(btnEditResetPhone);
		
		JButton btnEditResetBio = new JButton("Edit");
		btnEditResetBio.setBounds(380, 328, 85, 23);
		add(btnEditResetBio);
		
		JButton btnEditResetPicture = new JButton("Edit");
		btnEditResetPicture.setBounds(362, 438, 85, 23);
		add(btnEditResetPicture);
		
	}
}
