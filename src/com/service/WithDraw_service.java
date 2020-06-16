package com.service;

import java.sql.SQLException;
import com.dao.WithDraw_dao;
import com.model_class.Account_model;

public class WithDraw_service {
	
 WithDraw_dao  d_dao = new WithDraw_dao();
 

	public String withdraw_money(Account_model account) throws SQLException,ClassNotFoundException
	{
		return d_dao.withdraw_money(account);
	}
}
