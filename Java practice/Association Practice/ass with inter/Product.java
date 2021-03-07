import java.lang.*;

public class Product
{
	private String productId;
	private String productName;
	private int availableQuantity;
	private double price;
	
	public Product(){}
	public Product(String pid, String pName, int q, double p)
	{
		this.productId = pid;
		this.productName = pName;
		this.availableQuantity = q;
		this.price = p;
	}
	
	public void setProductId(String pid){this.productId = pid;}
	public void setProductName(String pName){this.productName = pName;}
	public void setAvailableQuantity(int q){this.availableQuantity = q;}
	public void setPrice(double p){this.price = p;}
	
	public String getProductId(){return productId;}
	public String getProductName(){return productName;}
	public int getAvailableQuantity(){return availableQuantity;}
	public double getPrice(){return price;}
	
	public void buyProducts(int quantity)
	{
		if(quantity>0)
		{
			availableQuantity = availableQuantity + quantity;
		}
		else{System.out.println("Oops, Something is Wrong !!");}
	}
	public void sellProducts(int quantity)
	{
		if(availableQuantity>=quantity && quantity>0)
		{
			availableQuantity = availableQuantity - quantity;
		}
		else{System.out.println("Oops, Something is Wrong !!");}
	}
}




