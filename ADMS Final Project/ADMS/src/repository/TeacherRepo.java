package repository;

import java.lang.*;
import java.util.ArrayList;

import interfaces.*;
import entity.*;

public class TeacherRepo implements iTeacher
{
	DatabaseConnection dbc;
	
	public TeacherRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public String[][] getAllTeacher()
	{
		ArrayList<Teacher> ar = new ArrayList<Teacher>();
		String query = "select * from teacher";
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String teacherId = dbc.result.getString("teacherId");
				String teacherName = dbc.result.getString("teacherName");
				String teacher_deptname = dbc.result.getString("teacher_deptname");
				double salary = dbc.result.getDouble("salary");
				String email = dbc.result.getString("email");
				
				Teacher t = new Teacher(teacherName, teacherId, teacher_deptname, email, salary);
				ar.add(t);

			}
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		Object obj[] = ar.toArray();
		
		String data[][] = new String [ar.size()][5];
		
		for(int i = 0; i<obj.length; i++)
		{
			data[i][0] = ((Teacher)obj[i]).getTeacher_Id();
			data[i][1] = ((Teacher)obj[i]).getTeacherName();
			data[i][2] = ((Teacher)obj[i]).getTeacher_deptname();
			data[i][3] = (((Teacher)obj[i]).getSalary())+"";
			data[i][4] = ((Teacher)obj[i]).getMail_address();
			
		}
		
		return data;
	}
	
	public void deleteTeacher(String teacherId)
	{
		String query = "DELETE FROM `teacher` WHERE `teacherId` = '"+teacherId+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public Teacher searchTeacher(String teacherId)
	{
		Teacher teach = null;
		String query = "SELECT teacherId, teacherName, teacher_deptname, salary, email FROM teacher WHERE teacherId='"+teacherId+"'";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				String teacherName = dbc.result.getString("teacherName");
				String teacher_deptname = dbc.result.getString("teacher_deptname");
				double salary = dbc.result.getDouble("salary");
				String email = dbc.result.getString("email"); 
				
				teach = new Teacher();
				teach.setTeacher_Id(teacherId);
				teach.setTeacherName(teacherName);
				teach.setTeacher_deptname(teacher_deptname);
				teach.setSalary(salary);
				teach.setMail_address(email);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return teach;
	}
	
	public void insertTeacher(Teacher t)
	{
		String query = "INSERT INTO teacher VALUES ('"+t.getTeacher_Id()+"','"+t.getTeacherName()+"','"+t.getTeacher_deptname()+"',"+t.getSalary()+",'"+t.getMail_address()+"','teacher')";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			//System.out.println(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
}