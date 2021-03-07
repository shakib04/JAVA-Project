import java.lang.*;

public class Person
{
	private int nid;
	private String name;
	private Car car;
	
	public Person(){}
	public Person(int nid, String name, Car car)
	{
		this.nid = nid;
		this.name = name;
		this.car = car;
	}
	
	public void setNid(int nid)
	{
		this.nid = nid;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setCar(Car car)
	{
		
		this.car = car;
		System.out.println(car);
	}
	public  int getNid(){return nid;}
	public String getName(){return name;}
	public Car getCar(){return car;}
}