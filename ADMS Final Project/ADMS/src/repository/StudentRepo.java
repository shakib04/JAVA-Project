package repository;

import java.lang.*;
import java.util.ArrayList;

import interfaces.*;
import entity.*;

public class StudentRepo implements iStudent
{
	DatabaseConnection dbc;
	
	public StudentRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public Student searchStudent(String studentId)
	{
		Student std = null;
		String query = "Select 	stu_Id,	studentName, stu_deptname,	cgpa,	credit_complete, contact_no, semester_name from student where stu_Id='"+studentId+"'";
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String name = dbc.result.getString("studentName");
				String deptno = dbc.result.getString("stu_deptname");
				String semester_name = dbc.result.getString("semester_name");
				double cgpa = dbc.result.getDouble("cgpa");
				int credit = dbc.result.getInt("credit_complete");
				String contact_no = dbc.result.getString("contact_no");
				
				std = new Student();
				std.setStu_Id(studentId);
				std.setStudentName(name);
				std.setStu_deptname(deptno);
				std.setSemester_Name(semester_name);
				std.setContact_no(contact_no);
				std.setCgpa(cgpa);
				std.setCredit_complete(credit);
				
					
			}
		}
		
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return std;
	}
	
	public String[][] getAllStudent()
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		String query = "select * from student";
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String stu_Id = dbc.result.getString("stu_Id");
				String studentName = dbc.result.getString("studentName");
				String stu_deptname = dbc.result.getString("stu_deptname");
				double cgpa = dbc.result.getDouble("cgpa");
				int credit_complete = dbc.result.getInt("credit_complete");
				String contact_no = dbc.result.getString("contact_no");
				String Semester_Name = dbc.result.getString("Semester_Name");
				
				Student s = new Student(studentName, stu_Id, stu_deptname, contact_no, cgpa, credit_complete, Semester_Name );
				ar.add(s);

			}
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		Object obj[] = ar.toArray();
		
		String data[][] = new String [ar.size()][7];
		
		for(int i = 0; i<obj.length; i++)
		{
			data[i][0] = ((Student)obj[i]).getStu_Id();
			data[i][1] = ((Student)obj[i]).getStudentName();
			data[i][2] = ((Student)obj[i]).getStu_deptname();
			data[i][3] = (((Student)obj[i]).getCgpa())+"";
			data[i][4] = (((Student)obj[i]).getCredit_complete())+"";
			data[i][5] = ((Student)obj[i]).getContact_no();
			data[i][6] = ((Student)obj[i]).getSemester_Name();
			
		}
		
		return data;
	}
	
	public void insertStudent(Student s)
	{
		String query = "INSERT INTO student VALUES ('"+s.getStu_Id()+"','"+s.getStudentName()+"','"+s.getStu_deptname()+"',"+s.getCgpa()+","+s.getCredit_complete()+",'"+s.getContact_no()+"','student','"+s.getSemester_Name()+"')";
		
		
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	
	public void updateStudent(Student s)
	{
		String query ="UPDATE student SET studentName = '"+s.getStudentName()+"', stu_deptname = '"+s.getStu_deptname()+"', cgpa = '"+s.getCgpa()+"', credit_complete = '"+s.getCredit_complete()+"', contact_no = '"+s.getContact_no()+"', SEMESTER_NAME= '"+s.getSemester_Name()+"' WHERE student.stu_Id = '"+s.getStu_Id()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	
	public void deleteStudent(String studentId)
	{
		//Student s = null;
		String query = "DELETE FROM student WHERE student.stu_Id = '"+studentId+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public String[][] courseList(String studentId)
	{
		
		ArrayList<Course> ar = new ArrayList<Course>();
		String query = "select course_name from student s,course c where s.semester_name=c.semester and stu_id='"+studentId+"'"; 
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String course = dbc.result.getString("course_name");
				
				
				Course c = new Course(course);
				ar.add(c);

			}
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		Object obj[] = ar.toArray();
		
		String data[][] = new String [ar.size()][1];
		
		for(int i = 0; i<obj.length; i++)
		{
			data[i][0] = ((Course)obj[i]).getCourseName();
			
		}
		
		return data;
	}
	
	
		
	
}