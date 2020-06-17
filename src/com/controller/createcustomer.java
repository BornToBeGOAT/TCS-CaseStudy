package com.controller;
import com.model_class.Customer;
import com.service.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.*;
/**
 * Servlet implementation class createcustomer
 */
@WebServlet("/createcustomer")
public class createcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createcustomer() {
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
		
		
		int customerssnid = Integer.parseInt(request.getParameter("SSN ID"));
		String customername = request.getParameter("name");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String addressline1 =request.getParameter("address1");
	    String addressline2 =request.getParameter("address2");
	    String state =request.getParameter("state");
	    String city =request.getParameter("city");
		
	   
	    
	    Customer cust= new Customer();
	    cust.setSsnid(customerssnid);
	    cust.setName(customername);
	    cust.setAge(age);
	    cust.setAdd1(addressline1);
	    cust.setAdd2(addressline2);
	    cust.setState(state);
	    cust.setCity(city);
	    int status=Customer_Service.create(cust);
	    if(status>0)
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/createcustomer.jsp");
        
        
        out.println("Customer is created successfully");
        rd.include(request,response);
	    }else
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/createcustomer.jsp");
	        
	        
	        out.println("Sorry customer cannot be created");
	        rd.include(request,response);
		    
	    }
	}

}
