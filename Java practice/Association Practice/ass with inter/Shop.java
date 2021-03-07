import java.lang.*;

public class Shop implements IShop
{
	private String shopName;
	public Product products[];
	
	public Shop(){}
	public Shop(String shopName, int sizeOfArray)
	{
		this.shopName = shopName;
		this.products = new Product [sizeOfArray];
	}
	
	public void setShopName(String sname){this.shopName = sname;}
	public String getShopName(){return shopName;}
	
	
	public Product getProduct(String pid)
	{
		Product p = null;
		for(int i=0; i<products.length; i++)
		{
			if(products[i].getProductId().equals(pid))
			{
				p = products[i];
				break;
			}
		}
		System.out.println(p);
		return p;
	}
	
	
	
	public void addProduct(Product p)
	{
		for(int i=0; i<products.length; i++)
		{
			if(products[i] == null)
			{
				products[i] = p;
				break;
			}
		}
	}
	public void removeProduct(Product p)
	{
		for(int i=0; i<products.length; i++)
		{
			if(products[i] == p)
			{
				products[i] = null;
				break;
			}
		}
	}
}