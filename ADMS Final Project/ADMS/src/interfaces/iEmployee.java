package interfaces;

import java.lang.*;
import entity.*;

public interface iEmployee
{
    public void insertEmployee(Employee e);
    public void removeEmployee(String empId);
    public void updateEmployee(Employee e);
	
    public  Employee searchEmployee(String empId);
	
    public  String[][] getAllEmployee();

}