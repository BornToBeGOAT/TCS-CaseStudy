package com.services.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.model_class.AccountManagement;
import com.services.AccountServices;

public class AccountServicesImp implements AccountServices{
	
	Connection conn;
	PreparedStatement statement;

	public AccountServicesImp() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/retailbanking?user=root&password=root&useSSL=false&allowPublicKeyRetrival=true");

		
	}

	@Override
	public String addAccount(AccountManagement acct) throws SQLException {
		
		String sql = "insert into account_table(Account ID,Customer ID,Account Type,Balance) values(?,?,?,?)";
		statement=conn.prepareStatement(sql);
		statement.setInt(1, acct.getAccount_id());
		statement.setInt(2, acct.getCustomer_id());
		statement.setString(3, acct.getAccount_type());
		statement.setDouble(4, acct.getBalance());
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("inserted successfully!");

			return "success";
		}

		return "failure";
	}

}
