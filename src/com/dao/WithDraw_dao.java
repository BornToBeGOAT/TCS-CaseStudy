package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model_class.Account_model;
import com.util.connection_util;

public class WithDraw_dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	ResultSet rs = null;
	
	
	public String withdraw_money(Account_model account) throws SQLException,ClassNotFoundException
	{
		int total_balance = 0;
		String msg = "fail";
		con = connection_util.getConnection();
		ps = con.prepareStatement("select Balance from account_table where Account_ID=? AND Customer_ID=?");
		ps.setLong(1, account.getAccount_id());
		ps.setLong(2, account.getCustomer_id());
		rs= ps.executeQuery();
		if(rs.next())
		{
			 total_balance = rs.getInt(1);
			System.out.print(total_balance);
		}
	
		
		if(total_balance>=account.getBalance())
		{
			ps = con.prepareStatement("update account_table set Balance = Balance - ? where Account_ID=? AND Customer_ID=?");
			ps.setLong(1, account.getBalance());
			ps.setLong(2, account.getAccount_id());
			ps.setLong(3, account.getCustomer_id());
			
			int rowstatus = ps.executeUpdate();
			connection_util.closeConnection(con);
			connection_util.closeStatement(ps);
			if(rowstatus>0)
			{
				msg="sucess";
				return msg;
			}
			return msg;
		}
		else
		{
			msg = "nobalance";
			return msg;
		}
	
	}
}
