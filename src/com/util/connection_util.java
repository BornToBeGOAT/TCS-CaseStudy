package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;;

public class connection_util {
 private static final String url="jdbc:mysql://localhost:3306/retailbanking";
 private static final String username = "root";
 private static final String password ="root";
 
 public static Connection getConnection() {
	Connection con = null;
	try {
	Class.forName(url);
	con = DriverManager.getConnection(url,username,password);
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return con;
 }
 public static void closeConnection(Connection con)
 {
	 if(con!=null)
	 {
		 try {
			 con.close();
		 }catch (SQLException e)
		 {
			 e.printStackTrace();
		 }
	 }
 }
 
 public static void closeStatement(PreparedStatement ps) {
	 if(ps!=null)
	 {
		 try {
			 ps.close();
		 }catch (SQLException e)
		 {
			 e.printStackTrace();
		 }
	 }
 }
}
