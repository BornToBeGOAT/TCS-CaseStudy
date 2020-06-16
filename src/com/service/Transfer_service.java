package com.service;

import java.sql.SQLException;

import com.dao.Transfer_dao;
import com.model_class.Account_model;

public class Transfer_service {
	Transfer_dao  t_dao = new Transfer_dao();
	
	public String transfer_money(Account_model account,String source_acc_type,String target_acc_type) throws SQLException,ClassNotFoundException
	{
		
		return t_dao.transfer_money(account,source_acc_type,target_acc_type);
	}
}
