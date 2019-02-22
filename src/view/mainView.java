package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.studentModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class mainView extends JFrame {
	private JTable table;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 613);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 36, 748, 538);
		getContentPane().add(scrollPane);
		studentModel sm = new studentModel();
		table = new JTable(sm);
		scrollPane.setViewportView(table);
		
		JLabel lblSearch = new JLabel("Search student:");
		lblSearch.setFont(new Font("Impact", Font.PLAIN, 17));
		lblSearch.setBounds(225, 11, 129, 21);
		getContentPane().add(lblSearch);
		
		search = new JTextField();
		search.setText("insert name");
		search.setBounds(345, 13, 183, 21);
		getContentPane().add(search);
		search.setColumns(10);
		
		JButton btnAddStudent = new JButton("Add student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addView add = new addView();
				add.setVisible(true);
				JOptionPane.showMessageDialog(null,"Add student successful");
			}
		});
		
		btnAddStudent.setBounds(45, 108, 129, 23);
		getContentPane().add(btnAddStudent);
		
		JButton btnDeleteStudent = new JButton("Delete student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int rowNum=table.getSelectedRow();
				if(rowNum==-1) {
					JOptionPane.showMessageDialog(null,"Please select a student");
					
				}
				
				String ID =sm.getValueAt(rowNum, 0).toString();
				String sql = "delete from student where id='"+Integer.parseInt(ID)+"'";
				try {
					PreparedStatement ps;
					ResultSet rs = null;
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/student_manage","root","7792347a");  
					ps=con.prepareStatement("delete from students where id= ?");
					ps.setInt(1, Integer.parseInt(ID));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Delete successful");
					con.close();
				} catch(Exception e) {System.out.println(e);}
			}
		});
		btnDeleteStudent.setBounds(45, 153, 129, 23);
		getContentPane().add(btnDeleteStudent);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=search.getText().trim();
				String sql = "select * from students where name='" + name + "'";
				studentModel sm = new studentModel(sql);
				table.setModel(sm);
			}
		});
		btnNewButton.setBounds(538, 12, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnEditStudent = new JButton("Edit student");
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum=table.getSelectedRow();
				if(rowNum==-1) {
					JOptionPane.showMessageDialog(null,"Please select a student");
					
				}
				editView edit =new editView(sm,rowNum);
				edit.setVisible(true);
			}
		});
		btnEditStudent.setBounds(45, 186, 129, 23);
		getContentPane().add(btnEditStudent);
		
		JButton btnUpdate = new JButton("Refresh");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentModel sm = new studentModel();
				table.setModel(sm);
			}
		});
		btnUpdate.setBounds(45, 219, 129, 23);
		getContentPane().add(btnUpdate);
	
		
		
	}
}
