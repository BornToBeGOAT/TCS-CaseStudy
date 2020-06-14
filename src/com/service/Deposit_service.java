package com.service;

import java.sql.SQLException;

import com.dao.Deposit_dao;
import com.model_class.Account_model;

public class Deposit_service {

	Deposit_dao  d_dao = new Deposit_dao();
	
	public boolean Deposit_money(Account_model account) throws SQLException,ClassNotFoundException
	{
		return d_dao.deposit_money(account);
	}
}
