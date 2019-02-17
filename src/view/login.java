package view;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setBounds(10, 10, 129, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(10, 65, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(10, 84, 228, 21);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 106, 54, 15);
		contentPane.add(lblPassword);
		
		pw = new JTextField();
		pw.setBounds(10, 131, 228, 21);
		contentPane.add(pw);
		pw.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/student_manage","root","7792347a");  
					//here sonoo is database name, root is username and password  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from users where username='" + user.getText()+"' ");  
					if(rs.next()) {
						System.out.println(rs.getString(1));
						JOptionPane.showMessageDialog(null,"Login successful");}
					else
						JOptionPane.showMessageDialog(null,"Incorrect user");
					con.close();
				} catch(Exception e) {System.out.println(e);}
					
				
			}
		});
		btnLogin.setBounds(10, 181, 93, 23);
		contentPane.add(btnLogin);
	}
}
