package database;
import java.sql .*;

import javax.swing.JOptionPane;
public class studentDAO {

	PreparedStatement ps;
	ResultSet rs = null;
	
	
	public boolean save(student student) {
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student_manage","root","7792347a");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			String sql = "INSERT INTO students(name,age,sex,grade,phone,email) values(?,?,?,?,?,?)";
			//setup the data for student to insert
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getSex());
			ps.setString(4, student.getGrade());
			ps.setString(5, student.getTel());
			ps.setString(6, student.getEmail());
			int count = ps.executeUpdate();
			//return count >0 which sql database was updated
			if(count>0)
				flag = true;
			//ResultSet rs=stmt.executeQuery("select * from admin where username='" + user.getText()+"'"+"and "+"pw='"+pw.getText()+"'");  
			con.close();
		} catch(Exception e) {System.out.println(e);}
		return flag;
	}
	
}
