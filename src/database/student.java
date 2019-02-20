package database;
import java.sql.*;
public class student {
	   private int id;
	   private String name;
	   private int age;
	   private String sex;
	   private String grade;
	   private String tel;
	   private String email;
public student() {
	super();
	
}
	
public student(int id, String name, int age, String sex, String grade, String tel, String email) {
	super();
	this.id=id;
	this.name=name;
	this.age=age;
	this.sex=sex;
	this.grade=grade;
	this.tel=tel;
	this.email=email;
	
}
@Override
public String toString() {
    return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex="
            + sex + ", grade=" + grade + ", tel=" + tel + ", email=" + email
           + "]";
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    student other = (student) obj;
    if (age != other.age)
        return false;
    if (email == null) {
        if (other.email != null)
            return false;
    } else if (!email.equals(other.email))
        return false;
    if (grade == null) {
        if (other.grade != null)
            return false;
    } else if (!grade.equals(other.grade))
        return false;
    if (id != other.id)
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    if (sex == null) {
        if (other.sex != null)
            return false;
    } else if (!sex.equals(other.sex))
        return false;
    if (tel == null) {
        if (other.tel != null)
            return false;
    } else if (!tel.equals(other.tel))
        return false;
    return true;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
public String getSex() {
    return sex;
}
public void setSex(String sex) {
    this.sex = sex;
}
public String getGrade() {
    return grade;
}
public void setGrade(String grade) {
    this.grade = grade;
}
public String getTel() {
    return tel;
}
public void setTel(String tel) {
    this.tel = tel;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}


}
