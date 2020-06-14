package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model_class.Account_model;
import com.service.Customer_Service;
import com.service.Deposit_service;

public class Deposit_controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
	{
		String source = request.getParameter("source");
		if(source.equalsIgnoreCase("deposit"))
		{
			response.sendRedirect("deposit.html");
		}
		
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
	{
		Deposit_service d_service = new Deposit_service ();
		String source = request.getParameter("source");
		if(source.equalsIgnoreCase("deposit"))
		{
			Account_model acc_model = new Account_model();
			acc_model.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
			acc_model.setAccount_id(Integer.parseInt(request.getParameter("account_id")));
			acc_model.setAccount_type(request.getParameter("account_type"));
			acc_model.setBalance(Integer.parseInt(request.getParameter("deposit_amt")));
			
			System.out.println("acc details "+acc_model.getAccount_id());
			
			try {
				boolean flag = d_service.Deposit_money(acc_model);
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
