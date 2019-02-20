package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import database.student;
import database.studentDAO;
import model.studentModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField phone;
	private JTextField grade;
	private JTextField sex;
	private JTextField age;
	private JTextField name;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addView dialog = new addView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setFont(new Font("宋体", Font.PLAIN, 15));
			lblName.setBounds(10, 10, 82, 18);
			contentPanel.add(lblName);
		}
		{
			JLabel lblAge = new JLabel("Age:");
			lblAge.setFont(new Font("宋体", Font.PLAIN, 15));
			lblAge.setBounds(10, 33, 82, 18);
			contentPanel.add(lblAge);
		}
		{
			JLabel lblSex = new JLabel("Sex:");
			lblSex.setFont(new Font("宋体", Font.PLAIN, 15));
			lblSex.setBounds(10, 61, 82, 18);
			contentPanel.add(lblSex);
		}
		{
			JLabel lblGrade = new JLabel("Grade:");
			lblGrade.setFont(new Font("宋体", Font.PLAIN, 15));
			lblGrade.setBounds(10, 89, 82, 18);
			contentPanel.add(lblGrade);
		}
		{
			JLabel lblPhoneNumber = new JLabel("Phone Number:");
			lblPhoneNumber.setFont(new Font("宋体", Font.PLAIN, 15));
			lblPhoneNumber.setBounds(10, 117, 106, 18);
			contentPanel.add(lblPhoneNumber);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("宋体", Font.PLAIN, 15));
			lblEmail.setBounds(10, 145, 82, 18);
			contentPanel.add(lblEmail);
		}
		{
			phone = new JTextField();
			phone.setBounds(113, 116, 171, 19);
			contentPanel.add(phone);
			phone.setColumns(10);
		}
		{
			grade = new JTextField();
			grade.setColumns(10);
			grade.setBounds(113, 88, 171, 19);
			contentPanel.add(grade);
		}
		{
			sex = new JTextField();
			sex.setColumns(10);
			sex.setBounds(113, 60, 171, 19);
			contentPanel.add(sex);
		}
		{
			age = new JTextField();
			age.setColumns(10);
			age.setBounds(113, 32, 171, 19);
			contentPanel.add(age);
		}
		{
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(113, 9, 171, 19);
			contentPanel.add(name);
		}
		{
			email = new JTextField();
			email.setColumns(10);
			email.setBounds(113, 145, 171, 19);
			contentPanel.add(email);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						studentDAO sd = new studentDAO();
						student add = new student(0,name.getText(),Integer.parseInt(age.getText()),sex.getText(),grade.getText(),phone.getText(),email.getText());
						sd.save(add);
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
