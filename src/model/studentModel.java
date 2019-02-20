package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table .*;
public class studentModel extends AbstractTableModel {
	Vector<Vector> rowData = new Vector();
	String[] columnName = new String[]{"Id","Name","Age","Sex","Grade","Phone number","Email"};
	
	public void init(String sql) {
		if(sql.equals("")) {
			sql="select * from students";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student_manage","root","7792347a");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(sql);
			//DefaultTableModel  tm =(DefaultTableModel)table.getModel();
			
			while(rs.next()) {
				//Object o[] = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getObject(7)};
				Vector add = new Vector();
				add.add(rs.getInt(1));
				for (int i =2;i<=7;i++) {
					add.add(rs.getString(i));
				}
				rowData.add(add);
			}
			
			con.close();
		} catch(Exception e) {System.out.println(e);}
		
		
	}
	
	
	public studentModel() {
		init("");
		
	}
	public studentModel(String sql) {
		
		init(sql);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnName.length;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		
		return this.columnName[arg0];
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return this.rowData.get(arg0).get(arg1);
	}

}
