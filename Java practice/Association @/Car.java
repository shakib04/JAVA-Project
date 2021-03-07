import java.lang.*;

public class Car
{
	private String regNo;
	private String model;
	private String manufacturer;
	
	public Car(){}
	public Car(String regNo, String model, String manufacturer)
	{
		this.regNo = regNo;
		this.model = model;
		this.manufacturer = manufacturer;
	}
	public void setRegNo(String regNo)
	{
		this.regNo = regNo;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	public String getRegNo(){return regNo;}
	public String getModel(){return model;}
	public String getManufacturer(){return manufacturer;}
}