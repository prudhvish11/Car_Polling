package ABC;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class car_mangement {

	public boolean addUser(LoginDetails loginde) throws SQLException, ClassNotFoundException
	{
		boolean ab=false;
		try
		{
			Connection con=DB.getConnection();
			PreparedStatement ptstmt=con.prepareStatement("insert into LoginDetails(username,password,role) values(?,?,?)");
		ptstmt.setString(1,loginde.getUsername());
		ptstmt.setString(2,loginde.getPassword());
		ptstmt.setString(3,loginde.getRole());
		int count=ptstmt.executeUpdate();
		if(count>0)
		{
			ab=true;
		}
		
		ptstmt.close();
		}
		catch(Exception e)
		{
		System.out.println("asdfghj"+e);	
		}
		
		finally
		{
			
		}
		return ab;
		
	}
	
	public boolean getuserdetails(LoginDetails loginde)
	{
		boolean ab=false;
		Statement sts=null;
		ResultSet rs=null;
		try
		{
			Connection con=DB.getConnection();
//			PreparedStatement ptstmt=con.prepareStatement("insert into LoginDetails(username,password,role) values(?,?,?)");
//		ptstmt.setString(1,loginde.getUsername());
//		ptstmt.setString(2,loginde.getPassword());
//		ptstmt.setString(3,loginde.getRole());
//		int count=ptstmt.executeUpdate();
			sts=con.createStatement();
			String query="select * from logindetails where username='"+loginde.getUsername()+"' AND password='"+loginde.getPassword()+"' Order by username";
			rs=sts.executeQuery(query);
			
		if(rs.next())
		{
			String uss=rs.getString("username");
			System.out.println("user alraedy found");
			return true;
		}
		rs.close();
		sts.close();
//		ptstmt.close();
		}
		catch(Exception e)
		{
		System.out.println("getdetails "+e);	
		}
		
		finally
		{
			
		}
		return ab;
	}
	
	public boolean detailssave(PoolDetails pd)
	{
		boolean ab=false;
		try
		{
			Connection con=DB.getConnection();
			
		PreparedStatement ptstmt=con.prepareStatement("insert into PoolDetails(name,date,carno,amount,pickup,destination) values(?,?,?,?,?,?)");
		ptstmt.setString(1,pd.getName());
		System.out.println("pd.getname"+pd.getName());
		ptstmt.setDate(2,java.sql.Date.valueOf(pd.getDate()));
		ptstmt.setString(3,pd.getCarNo());
		ptstmt.setInt(4,pd.getAmount());
		ptstmt.setString(5,pd.getPickup());
		ptstmt.setString(6,pd.getDestination());
		int count=ptstmt.executeUpdate();
		if(count>0)
		{
			ab=true;
		}
		
		ptstmt.close();
		}
		catch(Exception e)
		{
		System.out.println("details save "+e);	
		}
		
		finally
		{
			
		}
		return ab;
	}
	public ArrayList<PoolDetails> viewalldetails(String userm)
	{
		Statement sts=null;
		ResultSet rs=null;
		ArrayList<PoolDetails> pdl=new ArrayList<>();
		
		try
		{
			System.out.println(userm);
			Connection con=DB.getConnection();
//			PreparedStatement ptstmt=con.prepareStatement("insert into LoginDetails(username,password,role) values(?,?,?)");
//		ptstmt.setString(1,loginde.getUsername());
//		ptstmt.setString(2,loginde.getPassword());
//		ptstmt.setString(3,loginde.getRole());
//		int count=ptstmt.executeUpdate();
			sts=con.createStatement();
			String query="select * from pooldetails where name='"+userm+"'";
			rs=sts.executeQuery(query);
			System.out.println(userm);
			while(rs.next())
			{
				System.out.println("vales are presnet");
			pdl.add(new PoolDetails(rs.getString("name"),rs.getDate("date").toLocalDate(),rs.getString("carno"),rs.getInt("amount"),rs.getString("pickup"),rs.getString("destination")));
			}
		rs.close();
		sts.close();
//		ptstmt.close();
		}
		catch(Exception e)
		{
		System.out.println("getdetails "+e);	
		}
		System.out.println(userm);
		return pdl;
	}
}