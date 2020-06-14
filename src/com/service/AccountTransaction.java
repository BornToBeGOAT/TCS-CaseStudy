package com.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model_class.AccountManagement;
import com.services.AccountServices;
import com.services.implementation.AccountServicesImp;

/**
 * Servlet implementation class AccountTransaction
 */

@WebServlet(name = "AccountTransaction", urlPatterns = "/AccountTransaction")
public class AccountTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @param account_id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, int account_id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int account_id1, customer_id;
		String account_type;
		double balance;
		
		account_id1=Integer.parseInt(request.getParameter("account_id"));
		customer_id=Integer.parseInt(request.getParameter("customer_id"));
		account_type=request.getParameter("account_type");
		balance=Double.parseDouble(request.getParameter("balance"));
		
		AccountManagement account = new AccountManagement(account_id1,customer_id, account_type, balance);
		try {
			AccountServices accountservice = new AccountServicesImp();

			String result = accountservice.addAccount(account);

			// if ("success".equalsIgnoreCase(result)) {

			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.include(request, response);
			rd.forward(request, response);
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
