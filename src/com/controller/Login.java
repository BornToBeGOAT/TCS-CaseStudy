package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.LoginPageDAO;
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;   

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String uname=request.getParameter("uname");  
	    String psw=request.getParameter("psw");  
	          
	    if(LoginPageDAO.validate(uname,psw)){  
	    	HttpSession session = request.getSession(true);  
	    	session.setAttribute("name",uname);
//	    	HttpSession session = request.getSession(false);// don't create if it doesn't exist
//	    	if(session != null && !session.isNew()) {
//	    	    chain.doFilter(request, response);
//	    	} else {
//	    	    response.sendRedirect("/Login.jsp");
//	    	}
	    	
	    	
	        RequestDispatcher rd=request.getRequestDispatcher("homepage.html");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	}

}
