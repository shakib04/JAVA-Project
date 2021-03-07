import java.lang.*;

public interface IShop
{
	public Product getProduct(String productId);
	public void addProduct(Product p);
	public void removeProduct(Product p);
}