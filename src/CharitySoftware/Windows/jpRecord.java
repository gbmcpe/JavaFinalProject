package CharitySoftware.Windows;

import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class jpRecord extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Connection conn;

	/**
	 * Create the panel.
	 */
	public jpRecord(Connection dbconn) {
		
		conn = dbconn;
		
		setLayout(null);
		
		JLabel lblName = new JLabel("[NAME TITLE]");
		lblName.setBounds(204, 45, 136, 14);
		add(lblName);
		
		JTextPane txtpnBioArea = new JTextPane();
		txtpnBioArea.setEditable(false);
		txtpnBioArea.setText("Bio Area");
		txtpnBioArea.setBounds(259, 145, 254, 350);
		add(txtpnBioArea);
		
		JLabel lblSchool = new JLabel("[SCHOOL]");
		lblSchool.setBounds(111, 226, 89, 14);
		add(lblSchool);
		
		JLabel lblUniversity = new JLabel("[UNIVERSITY]");
		lblUniversity.setBounds(111, 255, 89, 14);
		add(lblUniversity);
		
		//Setting up the Image (if applicable) 
		
		JLabel lblStudentImage = new JLabel("image");
		lblStudentImage.setBounds(76, 45, 149, 170);
		
		//Image img = new ImageIcon(this.getClass().getResource("img_not_found.jpg")).getImage();
		//lblStudentImage.setIcon(new ImageIcon(img));
		add(lblStudentImage);
		
		JLabel lblMajor = new JLabel("[MAJOR]");
		lblMajor.setBounds(111, 291, 89, 14);
		add(lblMajor);
		
		JLabel lblEmail = new JLabel("[EMAIL]");
		lblEmail.setBounds(111, 323, 89, 14);
		add(lblEmail);
		
		JLabel lblPhone = new JLabel("[PHONE]");
		lblPhone.setBounds(111, 347, 89, 14);
		add(lblPhone);
		
		
		
		
	}
}
