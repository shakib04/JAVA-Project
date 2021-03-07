package repository;
import java.lang.*;
import java.util.ArrayList;

import interfaces.*;
import entity.*;

public class EmployeeRepo implements iEmployee
{
    DatabaseConnection dbc;

    public EmployeeRepo()
    {
        dbc = new DatabaseConnection();
    }

    public Employee searchEmployee(String empId)
    {
        Employee emp = null;
        String query = "SELECT empId, employeeName,designation, salary FROM employee WHERE empId='"+empId+"'";

             try
            {
                dbc.openConnection();
                dbc.result = dbc.st.executeQuery(query);

                while(dbc.result.next())
                {
                    String name = dbc.result.getString("employeeName");
                    String designation = dbc.result.getString("designation");
                    double salary = dbc.result.getDouble("salary");

                    emp = new  Employee();
                    emp.setEmpId(empId);
                    emp.setEmpName(name);
                    emp.setEmpSalary(salary);
                    emp.setDesignation(designation);

                }
            }
            catch(Exception ex){System.out.println(ex.getMessage());}
             dbc.closeConnection();
             return emp;
    }
	
	public  String[][] getAllEmployee()
	{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		String query = "SELECT * FROM employee";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String empId = dbc.result.getString("empId");
				String name = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				Employee e = new Employee(empId,name,designation,salary);
				ar.add(e);
			}
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId();
			data[i][1] = ((Employee)obj[i]).getEmpName();
			data[i][2] = ((Employee)obj[i]).getDesignation();
			data[i][3] = (((Employee)obj[i]).getEmpSalary())+"";
		}
		return data;
	}
	
	public void insertEmployee(Employee e)
	{
		String query = "INSERT INTO employee VALUES ('"+e.getEmpId()+"','"+e.getEmpName()+"','"+e.getDesignation()+"',"+e.getEmpSalary()+",'employee')";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			//System.out.println(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateEmployee(Employee e)
	{
		String query = "UPDATE employee SET employeeName='"+e.getEmpName()+"', designation = '"+e.getDesignation()+"', salary = "+e.getEmpSalary()+" WHERE empId='"+e.getEmpId()+"'";
		
		try
		{
		
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void removeEmployee(String empId)
	{
		String query = "Delete from employee where empId='"+empId+"'";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
}