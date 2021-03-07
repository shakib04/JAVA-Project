package entity;
import java.lang.*;

public class Employee
{
	private String empName;
	private String empID;
	private double empSalary;
	private String designation;
	
	
	
	public Employee(){}
	
	public Employee(String empID,String empName,String designation,double empSalary)
	{
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
		this.designation = designation;
	}
	
	//setMethods

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	
	public void setEmpId(String empID)
	{
		this.empID = empID;
	}
	
	public void setEmpSalary(double empSalary)
	{
		this.empSalary = empSalary;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	//getMethods

	public String getEmpName()
	{
		return empName;
	}

	public String getEmpId()
	{
		return empID;
	}

	public double getEmpSalary()
	{
		return empSalary;
	}

	public String getDesignation() {
		return designation;
	}

}