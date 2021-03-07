import java.lang.*;

public class Book
{
	private String bookName;
	private int bookId;
	private int price;
	
	public Book(String bookName,int bookId)
	{
		this.bookName=bookName;
		this.bookId=bookId;
	}
	
	public String getbookName() { return bookName; }
	public int getbookId ( ) { return bookId; }
	
	
	//price 
	public void setBookPrice(int price) 
	{
		this.price=price;
	}
	
	public int getBookPrice() { return price; } 
	
	
		
}