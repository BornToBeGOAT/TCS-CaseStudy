package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model_class.Account_model;
import com.service.Deposit_service;
import com.service.WithDraw_service;

public class WithDraw_controller extends HttpServlet {
private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
	{
		String message = null;
		WithDraw_service w_service = new WithDraw_service();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/withdraw.html");
		PrintWriter out = response.getWriter();
		String source = request.getParameter("source");
		/// values///
		int accnt_id =Integer.parseInt(request.getParameter("account_id"));
		int cust_id =Integer.parseInt(request.getParameter("customer_id"));
		String acc_type = request.getParameter("account_type");
		int balance =Integer.parseInt(request.getParameter("withdraw_amt"));
		
//		if(accnt_id==null || accnt_id==0 || Integer.SIZE!=11)
//		{
//			message = "Invalid Account ID.";
//		}
//		
//		if(cust_id==null || cust_id==0 || Integer.SIZE!=11)
//		{
//			message = "Invalid Customer ID";
//		}
//		if(acc_type==null || acc_type.equals(""))
//		{
//			message = "Account Type cannot be Empty";
//		}
//		
//		if(balance==null )
//		{
//			message = "Balance ID cannot be Empty";
//		}
		
//		if(message!=null)
//		{
//			
//			out.println("<font color=red>" +message+"</font>");
//			rd.include(request, response);
//			
//		}
		if(source.equalsIgnoreCase("withdraw"))
		{
			Account_model acc_model = new Account_model();
			acc_model.setAccount_id(accnt_id);
			acc_model.setCustomer_id(cust_id);
			acc_model.setAccount_type(acc_type);
			acc_model.setBalance(balance);
		
		//	System.out.println("acc details "+acc_model.getAccount_id());
			
			try {
				String msg = w_service.withdraw_money(acc_model);
				if(msg.equalsIgnoreCase("sucess"))
				{
					out.println("<font color=red> WithDrawl SucessFull.</font>");
					rd.include(request, response);
				}
				else if(msg.equalsIgnoreCase("nobalance"))
				{
					out.println("<font color=red> Insufficient Balance for Withdrawl.</font>");
					rd.include(request, response);
				}
				else
				{
					out.println("<font color=red>Some unknown error occured,Amount not Withdrawed.</font>");
					rd.include(request, response);
				}
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
