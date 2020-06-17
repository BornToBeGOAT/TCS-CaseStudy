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
 * Servlet implementation class updatecustomer
 */
@WebServlet("/updatecustomer")
public class updatecustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecustomer() {
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
		String customername = request.getParameter("name");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String addressline1 =request.getParameter("address1");
	    String addressline2 =request.getParameter("address2");
       
	    
	    Customer cust= new Customer();
	    cust.setCid(customerid);
	    cust.setSsnid(customerssnid);
	    cust.setName(customername);
	    cust.setAge(age);
	    cust.setAdd1(addressline1);
	    cust.setAdd2(addressline2);
	    
	    int status=Customer_Service.update(cust);
	    if(status>0)
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/update.jsp");
        
        
        out.println("Customer is updated successfully");
        rd.include(request,response);
	    }else
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/update.jsp");
	        
	        
	        out.println("Sorry customer cannot be updated");
	        rd.include(request,response);
		    

	}

	}
}