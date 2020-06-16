package com.dao;

import java.sql.*;

public class LoginPageDAO {

	public static boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		
		boolean status=false;  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
		      
		PreparedStatement ps=con.prepareStatement(  
		"SELECT * FROM userstore where login=? and password=?");  
		ps.setString(1,username);  
		ps.setString(2,password);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		  
	}

}
