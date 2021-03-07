import java.lang.*;

public class Start
{
	public static void main(String args[])
	{
		Shop s1 = new Shop("AIUB", 5);
		
		Product p1 = new Product("P001", "Marker", 10, 100);
		Product p2 = new Product("P002", "Laptop", 5, 100000);
		Product p3 = new Product("P003", "Mobile", 8, 10000);
		Product p4 = new Product("P004", "Pen Drive", 100, 500);
		
		
		s1.addProduct(p1);
		s1.addProduct(p2);
		s1.addProduct(p3);
		
		
		System.out.println("Name : "+ s1.getShopName());
		
		System.out.println("---------------");
		
		for(int i=0; i<s1.products.length; i++)
		{
			if(s1.products[i] != null)
			{
				System.out.println("Product Id: "+ s1.products[i].getProductId());
				System.out.println("Product Name: "+ s1.products[i].getProductName());
				System.out.println("Available Quantity: "+ s1.products[i].getAvailableQuantity());
				System.out.println("Price: "+ s1.products[i].getPrice());
				System.out.println();
			}
		}
	}
}








