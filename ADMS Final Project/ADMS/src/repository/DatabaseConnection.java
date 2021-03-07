package repository;

import java.sql.*;
import entity.*;
import interfaces.*;

public class DatabaseConnection
{
	public Connection con;
	public Statement st;
	public ResultSet result;
	
	public  DatabaseConnection(){}
	
	public void openConnection()
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","adms","adms");
			st = con.createStatement();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void closeConnection()
	{
		try
		{
			if(con!=null){con.close();}
			if(st!=null){st.close();}
			if(result!=null){result.close();}
		}
		catch(Exception e){}
	}
}