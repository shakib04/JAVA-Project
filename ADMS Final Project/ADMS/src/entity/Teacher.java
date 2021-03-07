package entity;
import java.lang.*;

public class Teacher
{
    String teacherName;
    String teacher_Id;
    String teacher_deptname;
    double salary;
	String mail_address;


	public Teacher(){}
	
    public Teacher(String teacherName, String teacher_Id, String teacher_deptname, String mail_address,double salary)
    {
        this.teacherName = teacherName;
        this.teacher_Id = teacher_Id;
        this.teacher_deptname = teacher_deptname;
        this.mail_address = mail_address;
        this.salary = salary;
        //this.credit_complete = credit_complete;
		
		//this.father_name = father_name;
        //this.mother_name  = mother_name;
		//this.local_address = local_address;
    }
	
	//setMethods

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacher_Id(String teacher_Id) {
        this.teacher_Id = teacher_Id;
    }

    public void setTeacher_deptname(String teacher_deptname) {
        this.teacher_deptname = teacher_deptname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }



		//getMethods
		
    public double getSalary() {
        return salary;
    }

    public String getMail_address() {
        return mail_address;
    }

    public String getTeacher_deptname() {
        return teacher_deptname;
    }

    public String getTeacher_Id() {
        return teacher_Id;
    }

    public String getTeacherName() {
        return teacherName;
    }
    
}