package database;
import java.sql.*;
public class students {
	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/student_manage","root","7792347a");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from students where age=1");  
		while(rs.next()) {
			System.out.println(rs.getString(1));
		} 
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}

}
