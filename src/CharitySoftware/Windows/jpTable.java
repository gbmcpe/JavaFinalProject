package CharitySoftware.Windows;

import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jpTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbDatabase;
	private JTextField txtfSearch;
	private Connection conn;

	/**
	 * Create the panel.
	 */
	public jpTable(Connection dbconn) {
		setLayout(null);
		
		conn = dbconn;
		
		tbDatabase = new JTable();
		tbDatabase.setBounds(46, 87, 479, 208);
		tbDatabase.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		add(tbDatabase);
		
		/*
		 * Toggle Graduates /Primary Clickevent
		 */
		
		JToggleButton tglbtnGraduates = new JToggleButton("Mode: Primary School Students");
		tglbtnGraduates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tglbtnGraduates.isSelected())
				{
				tglbtnGraduates.setText("Mode: University Students");
				}
				else 
				{
				tglbtnGraduates.setText("Mode: Primary School Students");
				}
				
			}
		});
		tglbtnGraduates.setBounds(148, 21, 254, 23);
		add(tglbtnGraduates);
		
		JComboBox cmbxSortBy = new JComboBox();
		cmbxSortBy.setModel(new DefaultComboBoxModel(new String[] {"Sort By", "Col1", "Col2", "Col3"}));
		cmbxSortBy.setBounds(366, 55, 61, 22);
		add(cmbxSortBy);
		
		txtfSearch = new JTextField();
		txtfSearch.setBounds(121, 55, 86, 20);
		add(txtfSearch);
		txtfSearch.setColumns(10);
		
		JLabel lblSearchFor = new JLabel("Search For:");
		lblSearchFor.setBounds(46, 58, 78, 14);
		add(lblSearchFor);
		
		JLabel lblIn = new JLabel("in:");
		lblIn.setBounds(217, 58, 20, 14);
		add(lblIn);
		
		JComboBox cmbxCols = new JComboBox();
		cmbxCols.setModel(new DefaultComboBoxModel(new String[] {"column...", "col1", "col2", "col3"}));
		cmbxCols.setBounds(247, 55, 95, 21);
		add(cmbxCols);
		
		
		
		
		
	}
}
