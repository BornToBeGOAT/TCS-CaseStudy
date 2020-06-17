package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model_class.customerstatusmodel;

/**
 * Servlet implementation class Customer_Status
 */
@WebServlet("/Customer_Status")
public class Customer_Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_Status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con;
		ArrayList<customerstatusmodel> customerstatusmodelData = new ArrayList<customerstatusmodel>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
			PreparedStatement ps = con.prepareStatement( "select * from customerstatus");
			ResultSet rs = ps.executeQuery();
			while (rs.next ()){
				String customerId,customerSSNId,Status,Message,LastUpdated;
				customerId=rs.getString(1);
				customerSSNId=rs.getString(2);
				Status=rs.getString(3);
				Message=rs.getString(4);
				LastUpdated=rs.getString(5);
				customerstatusmodel ac= new customerstatusmodel(customerId,customerSSNId,Status,Message,LastUpdated);
				customerstatusmodelData.add(ac);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("data",customerstatusmodelData);
        RequestDispatcher rd=request.getRequestDispatcher("customer_status.jsp");  
        rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
