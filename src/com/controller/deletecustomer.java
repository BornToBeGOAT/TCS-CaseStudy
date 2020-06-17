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
 * Servlet implementation class deletecustomer
 */
@WebServlet("/deletecustomer")
public class deletecustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecustomer() {
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

		int customerid = Integer.parseInt(request.getParameter("Customer ID"));
		int customerssnid = Integer.parseInt(request.getParameter("Customer SSN ID"));

	   
	    Customer cust= new Customer();
	    cust.setCid(customerid);
	    cust.setSsnid(customerssnid);

	    int status=Customer_Service.delete(cust);
	    
	    if(status>0)
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/delete.jsp");
        
        
        out.println("<p>Customer is deleted successfully</p>");
        rd.include(request,response);
	    }else
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/delete.jsp");
	        
	        
	        out.println("<p>Sorry customer cannot be deleted</p>");
	        rd.include(request,response);
		    

	}


		
	}

}
