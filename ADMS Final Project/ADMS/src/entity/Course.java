package entity;

public class Course {

	public String course_name;

	public Course() {}
	
	public Course(String course_name)
	{
		this.course_name = course_name;
	}
	
	public void setCourseName(String course_name)
	{
		this.course_name = course_name;
	}
	
	public String getCourseName()
	{
		return course_name;
	}

}
