package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model_class.Account_model;
import com.util.connection_util;

public class Transfer_dao 
{
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	ResultSet result = null;
	ResultSet rs = null;
	
	public String transfer_money(Account_model account,String source_accnt_type,String target_accnt_type) throws SQLException,ClassNotFoundException
	{
		int total_balance = 0;
		String msg = "fail";
		con = connection_util.getConnection();
		ps = con.prepareStatement("select Balance from account_table where Customer_ID=? AND Account_type=?");
		ps.setLong(1, account.getCustomer_id());
		ps.setString(2,source_accnt_type );
		rs= ps.executeQuery();
		if(rs.next())
		{
			 total_balance = rs.getInt(1);
			// System.out.print(total_balance);
		}
	
		
		if(total_balance>=account.getBalance()) // source balance is more than transfer amount 
		{
			//deduct
			ps = con.prepareStatement("update account_table set Balance = Balance - ? where Customer_ID=? AND Account_type=?");
			ps.setLong(1, account.getBalance());
			ps.setLong(2, account.getCustomer_id());
			ps.setString(3,source_accnt_type);
			//System.out.println(source_accnt_type);
			
			//add
			ps1 = con.prepareStatement("update account_table set Balance = Balance + ? where Customer_ID=? AND Account_type=?");
			ps1.setLong(1, account.getBalance());
			ps1.setLong(2, account.getCustomer_id());
			ps1.setString(3,target_accnt_type);
			//System.out.println(target_accnt_type);
			
			int rowstatus = ps.executeUpdate();
			int rowstatus2 = ps1.executeUpdate();
			connection_util.closeConnection(con);
			connection_util.closeStatement(ps);
			connection_util.closeStatement(ps1);
			
			if(rowstatus>0 && rowstatus2>0 )
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

