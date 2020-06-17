package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model_class.Customer;
import com.service.Customer_Service;

/**
 * Servlet implementation class deletesearch
 */
@WebServlet("/deletesearch")
public class deletesearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletesearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int customerssnid = Integer.parseInt(request.getParameter("Customer SSN ID"));
		int customerid = Integer.parseInt(request.getParameter("Customer ID"));
		Customer cust= new Customer();
		cust.setSsnid(customerssnid);
		cust.setCid(customerid);
		int status = Customer_Service.search(cust);
		if(status>0)
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/delete.jsp");
        
	    	
        rd.forward(request,response);
	    }else
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/deletesearch.jsp");
	        
	        
	        out.println("Sorry no such customer exist");
	        rd.include(request,response);
		    
	    }


		
	}

}
