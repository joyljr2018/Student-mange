package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import database.student;
import database.studentDAO;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addView2 extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField sex;
	private JTextField grade;
	private JTextField phone;
	private JTextField email;


	/**
	 * Create the frame.
	 */
	public addView2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(22, 43, 79, 20);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(22, 65, 79, 20);
		contentPane.add(lblAge);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(22, 90, 79, 15);
		contentPane.add(lblSex);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(22, 115, 79, 15);
		contentPane.add(lblGrade);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(22, 140, 79, 15);
		contentPane.add(lblPhoneNumber);
		
		name = new JTextField();
		name.setBounds(106, 43, 102, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(106, 65, 102, 20);
		contentPane.add(age);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(106, 87, 102, 20);
		contentPane.add(sex);
		
		grade = new JTextField();
		grade.setColumns(10);
		grade.setBounds(106, 112, 102, 20);
		contentPane.add(grade);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(106, 137, 102, 18);
		contentPane.add(phone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(106, 164, 102, 20);
		contentPane.add(email);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(22, 167, 54, 15);
		contentPane.add(lblEmail);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentDAO sd = new studentDAO();
				student add = new student(0,name.getText(),Integer.parseInt(age.getText()),sex.getText(),grade.getText(),phone.getText(),email.getText());
				sd.save(add);
				dispose();
			}
		});
		btnAdd.setBounds(22, 194, 93, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(115, 194, 93, 23);
		contentPane.add(btnCancel);
	}

}
