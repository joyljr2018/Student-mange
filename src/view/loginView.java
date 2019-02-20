package view;

import java.awt.EventQueue;
import java.sql .*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;

public class loginView {

	private JFrame frame;
	private JTextField user;
	private JTextField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView window = new loginView();
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
	public loginView() {
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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/student_manage","root","7792347a");  
					//here sonoo is database name, root is username and password  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from admin where username='" + user.getText()+"'"+"and "+"pw='"+pw.getText()+"'");  
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login successful");
						frame.dispose();
						mainView frame = new mainView();
						frame.setVisible(true);
						
						}
					else
						JOptionPane.showMessageDialog(null,"Incorrect user");
					con.close();
				} catch(Exception b) 
				{System.out.println(b);
				}
					
			}
		});
		btnLogin.setBounds(24, 164, 93, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(24, 38, 93, 23);
		frame.getContentPane().add(lblUsername);
		
		user = new JTextField();
		user.setBounds(24, 63, 126, 23);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 96, 54, 15);
		frame.getContentPane().add(lblPassword);
		
		pw = new JTextField();
		pw.setBounds(24, 113, 126, 23);
		frame.getContentPane().add(pw);
		pw.setColumns(10);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane()}));
	}
}
