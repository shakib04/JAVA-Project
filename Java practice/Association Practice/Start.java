import java.lang.*;

public class Start
{
	public static void main(String args[])
	{
		Book b1=new Book("Gitanjoli",222);
		Student s1= new Student(b1);
		
		
		//System.out.println(b1.getbookName());
		//System.out.println("------------------------");
		//System.out.println((s1.getBook()).getbookName()); //book name print using student class
		
		b1.setBookPrice(400);
		
		System.out.println((s1.getBook()).getBookPrice());
		
		
	}
}
