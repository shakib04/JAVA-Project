import java.lang.*;

public class Student
{
	private int id;
	private String name;
	private String Semester;
	private String sec; 
	
	private Book b[];
	
	public Student (int arraySize)
	{
		this.b=new Book [arraySize];
	}	
	
	
	public Book bookN(String bookName)
	{
		Book bb = null;
		for (int i=0; i<b.length;i++)
		{
			
			System.out.println(b[i]);
		}
		return bb;
	}
	
	
	
	
}