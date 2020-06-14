package com.services;

import java.sql.SQLException;

import com.model_class.AccountManagement;



public interface AccountServices {
	
	public String addAccount(AccountManagement acct) throws SQLException;


}
