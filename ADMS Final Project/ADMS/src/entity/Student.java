package entity;
import java.lang.*;

public class Student
{
    String studentName;
    String stu_Id;
    String stu_deptname;
    double cgpa;
    int credit_complete;
	String contact_no;
	String Semester_Name;
	


	public Student(){}
	
    public Student(String studentName, String stu_Id, String stu_deptname, String contact_no,double cgpa,int credit_complete,String Semester_Name)
    {
        this.studentName = studentName;
        this.stu_Id = stu_Id;
        this.stu_deptname = stu_deptname;
        this.contact_no = contact_no;
        
        this.cgpa = cgpa;
        this.credit_complete = credit_complete;
        
        this.Semester_Name = Semester_Name;
		
		//this.father_name = father_name;
        //this.mother_name  = mother_name;
		//this.local_address = local_address;
    }
	
	//setMethods

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStu_Id(String stu_Id) {
        this.stu_Id = stu_Id;
    }

    public void setStu_deptname(String stu_deptname) {
        this.stu_deptname = stu_deptname;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setCredit_complete(int credit_complete) {
        this.credit_complete = credit_complete;
    }
    
    public void setSemester_Name(String Semester_Name)
    {
    	this.Semester_Name = Semester_Name;
    }



		//getMethods
		
    public double getCgpa() {
        return cgpa;
    }

    public int getCredit_complete() {
        return credit_complete;
    }

    public String getContact_no() {
        return contact_no;
    }


    public String getStu_deptname() {
        return stu_deptname;
    }

    public String getStu_Id() {
        return stu_Id;
    }

    public String getStudentName() {
        return studentName;
    }
    
    public String getSemester_Name()
    {
    	return Semester_Name;
    }
    
}