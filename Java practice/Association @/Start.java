import java.lang.*;

public class Start
{
	public static void main(String args[])
	{
		Car c1 = new Car();
		c1.setRegNo("Dhk Metro Ka - 12-4023");
		c1.setModel("Axio");
		c1.setManufacturer("Toyota");
		c1.setVisible(true);
		
		Person p1 = new Person();
		p1.setNid(111111111);
		p1.setName("Person 1");
		p1.setCar(c1);
		
		
		Car c2 = new Car("Dhk Metro Ka - 12-2023","Premio","Toyota");
		Person p2 = new Person(222222222,"Person 2", c2);
		
		System.out.println("NID: "+ p1.getNid());
		System.out.println("Name: "+ p1.getName());
		System.out.println("Car RegNo: "+ p1.getCar().getRegNo());
		System.out.println("Car Model: "+ p1.getCar().getModel());
		System.out.println("Car Manufacturer: "+p1.getCar().getManufacturer());
		
		System.out.println("---------------------");
		
		System.out.println("NID: "+ p2.getNid());
		System.out.println("Name: "+ p2.getName());
		System.out.println("Car RegNo: "+ p2.getCar().getRegNo());
		System.out.println("Car Model: "+ p2.getCar().getModel());
		System.out.println("Car Manufacturer: "+p2.getCar().getManufacturer());
		
	}
	
}



