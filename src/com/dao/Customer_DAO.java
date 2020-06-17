package com.dao;
import com.model_class.Customer;
import com.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Customer_DAO {
	 

	public static int createCustomer(Customer cust)
{
      PreparedStatement ps=null;
		 
	int status=0;
	System.out.println("DAO");
	try {
	Connection conn=connection_util.getConnection();
	ps=conn.prepareStatement("INSERT INTO `customer_table` (`Customer_SSN_ID`, `Customer_Name`, `Age`, `Address_Line1`, `Address_Line2`, `City`, `State`) VALUES (?,?,?,?,?,?,?)");
    
	ps.setInt(1,cust.getSsnid());
    ps.setString(2,cust.getName());
    ps.setInt(3,cust.getAge());
    ps.setString(4,cust.getAdd1());
    ps.setString(5,cust.getAdd2());
    ps.setString(6,cust.getCity());
    ps.setString(7,cust.getState());
    
   status =ps.executeUpdate();
   
   conn.close();

	}catch(Exception  e)
	{
		e.printStackTrace();
	}
	return status;
}

public static int searchCustomer(Customer cust)
{
	int status=0;
	try {
		
		PreparedStatement ps=null;

		Connection conn=connection_util.getConnection();
		ps=conn.prepareStatement("SELECT *  FROM `customer_table` WHERE `Customer_ID` = ? OR `Customer_SSN_ID` = ?");
		ps.setInt(1,cust.getCid());
		ps.setInt(2,cust.getSsnid());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			status=1;
		}
		conn.close();
	}catch(Exception  e)
	{
		e.printStackTrace();
	}
	
	return status;
}


public static int updateCustomer(Customer cust)
{
	int status=0;
try {
		
		PreparedStatement ps=null;

		Connection conn=connection_util.getConnection();
		ps=conn.prepareStatement("UPDATE `customer_table` SET `Customer_Name` = ?,  `Address_Line1` = ?, `Address_Line2` = ?, `Age` = ?  WHERE `customer_table`.`Customer_ID` = ?");
		ps.setString(1,cust.getName());
		ps.setString(2,cust.getAdd1());
		ps.setString(3,cust.getAdd2());
		ps.setInt(4,cust.getAge());
		ps.setInt(5, cust.getCid());
        status=ps.executeUpdate();
        
        conn.close();

        }catch(Exception  e)
         {
	        e.printStackTrace();
         }

	return status;
}


public static int deleteCustomer(Customer cust)
{
	int status=0;
try {
		
		PreparedStatement ps=null;

		Connection conn=connection_util.getConnection();
		ps=conn.prepareStatement("DELETE FROM `customer_table` WHERE `Customer_ID`=? OR `Customer_SSN_ID`=?");
		ps.setInt(1, cust.getCid());
		ps.setInt(2, cust.getSsnid());
        status=ps.executeUpdate();
        
        conn.close();

        }catch(Exception  e)
         {
	        e.printStackTrace();
         }

	return status;

}
}