import java.lang.*;

public class Student
{
	private int id;
	private String name;
	private String Semester;
	private String sec; 
	
	private Book b;
	
	public Student (Book b)
	{
		this.b=b;
	}	
	
	public Book getBook()
	{
		return b;
	}
	
	
	
	
}