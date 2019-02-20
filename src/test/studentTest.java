package test;
import database.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import database.studentDAO ;

class studentTest {
	studentDAO sd = new studentDAO();
	@Test
	void test() { 
		
	for(int i =0;i<100;i++) {	
	student stu = new student( 0, "张三", 12, "男","中级" , "12345678901", "12334455@qq.com");

    boolean flg = sd.save(stu);
	}
   // System.out.println(flg);
	}

}
