package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

import com.model_class.accountstatusmodel;



/**
 * Servlet implementation class Account_Status
 */
@WebServlet("/Account_Status")
public class Account_Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account_Status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con;
		ArrayList<accountstatusmodel> accountstatusmodelData = new ArrayList<accountstatusmodel>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
			PreparedStatement ps = con.prepareStatement( "select * from accountstatus ");
			ResultSet rs = ps.executeQuery();
			while (rs.next ()){
				String customerId,accountId,accountType,accountStatus,Message,LastUpdated;
				customerId=rs.getString(1);
				accountId=rs.getString(2);
				accountType=rs.getString(3);
				accountStatus=rs.getString(4);
				Message=rs.getString(5);
				LastUpdated=rs.getString(6);
				accountstatusmodel ac= new accountstatusmodel(customerId,accountId,accountType,accountStatus,Message,LastUpdated);
				accountstatusmodelData.add(ac);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("data",accountstatusmodelData);
        RequestDispatcher rd=request.getRequestDispatcher("account_status.jsp");  
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
