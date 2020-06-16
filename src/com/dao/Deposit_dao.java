package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model_class.Account_model;
import com.util.connection_util;

public class Deposit_dao  {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	
	public Boolean deposit_money(Account_model account) throws SQLException,ClassNotFoundException
	{
		Boolean flag = false;
		con = connection_util.getConnection();
		//UPDATE `reatilbanking`.`account_table` SET `Balance` = '10' WHERE (`Account ID` = '1234');
		ps = con.prepareStatement("update account_table set Balance = Balance + ? where Account_ID=? AND Customer_ID=?");
		ps.setLong(1, account.getBalance());
		ps.setLong(2, account.getAccount_id());
		ps.setLong(3, account.getCustomer_id());
		
		int rowstatus = ps.executeUpdate();
		connection_util.closeConnection(con);
		connection_util.closeStatement(ps);
		if(rowstatus>0)
		{
			return true;
		}
		return flag;
	}
}
