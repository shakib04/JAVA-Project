package interfaces;

import java.lang.*;
import entity.*;

public interface iStudent
{
	public String[][] getAllStudent();
	public Student searchStudent(String studentId);
	public void insertStudent(Student s);
	public void updateStudent(Student s);
	public void deleteStudent(String studentId);
}