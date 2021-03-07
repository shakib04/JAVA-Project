package interfaces;

import java.lang.*;
import entity.*;

public interface iTeacher
{
	public String[][] getAllTeacher();
	public Teacher searchTeacher(String teacherId);
	public void insertTeacher(Teacher t);
	//public void updateTeacher(Teacher t);
	public void deleteTeacher(String teacherId);
}