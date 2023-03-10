package ABC;

import java.io.*;
import java.util.*;
import java.sql.*;

public class DB {

	private static Connection con=null;
	private static Properties props=new Properties();
//	static String url = "jdbc:mysql://localhost:3306/puddi";
//	static String 	user = "root";
//	static String password = "";
	static String url = "jdbc:mysql://localhost:3306/testing";
	static String user = "root";
	static String password = "245822";
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		try
		{
//		FileInputStream fis=null;
//			fis=new FileInputStream()
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			return con;
	}catch(Exception e)
		{
		System.out.println("db error"+e);
		}
		finally
		{
		
		}
		return con;
	
}
}