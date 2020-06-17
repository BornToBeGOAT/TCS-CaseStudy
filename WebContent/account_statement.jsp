<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

	<%		
    	HttpSession ses = request.getSession(false);// don't create if it doesn't exist
    	if(ses != null && !ses.isNew()) {
    
	   	} else {
    	    response.sendRedirect("/Login.jsp");
    	}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Retail Banking System</title>
      <link rel="stylesheet" href="homepage.css">
      <style>
         
         table.border,table.heading{
         width:85%;
         }    
         table.border,th.row,td.col{
         border:1px solid black;
         border-collapse:collapse;
         opacity:0.95;
         }    
         th.row,td.col{
         padding:10px;
         text-align:center;
         }  
         th.row{
         background-color:yellow;
         color:black;
         }   
         tr:nth-child(even)
         {
         background-color:lightgray;
         }  
         tr:nth-child(odd)
         {
         background-color:lightgray;
         }           
      </style>
   </head>
   <body>
      <div class="header">
         <h1>FedChoice Bank</h1>
      </div>
      <div class="navbar">
         <a href="#">Home</a>
         <div class="dropdown">
            <button class="dropbtn">Customer Management
            </button>
            <div class="dropdown-content">
               <a href="#">Create Customer</a>
               <a href="#">Update Customer</a>
               <a href="#">Delete Customer</a>
               <a href="#">Search Customer</a>
            </div>
         </div>
         <div class="dropdown">
            <button class="dropbtn">Account Management
            </button>
            <div class="dropdown-content">
               <a href="#">Create Account</a>
               <a href="#">Delete Account</a>
               <a href="#">Search Account</a>
            </div>
         </div>
         <div class="dropdown">
            <button class="dropbtn">Account Operations
            </button>
            <div class="dropdown-content">
               <a href="#">Deposit Money</a>
               <a href="#">Withdraw Money</a>
               <a href="#">Transfer Money</a>
            </div>
         </div>
         <div class="dropdown">
            <button class="dropbtn">Status Details
            </button>
            <div class="dropdown-content">
               <a href="">Customer Status</a>
               <a href="Account_Status">Account Status</a>
               <a href="">Account statement</a>
            </div>
         </div>
         <a href="#">Log out</a>
      </div>
      <div class="main">
      <center>
      	<h1>Account Statement</h1>
      </center>
      <div class="register">
      <form>
      <table style="margin: 0 auto;" >
         <tbody>
            <tr>
               <td colspan="2">
                  <label for="accid">Account ID: </label>
                  <input type="number" name="accid" required>
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input type="radio" id="lastTransaction" name="transactionType" value="lastNoOfTransaction" checked  onclick="hideContainer();">
                  <label for="lastTransaction">Last Number of Transactions</label>
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input type="radio" id="StartEndDates" name="transactionType" value="StartEndDates"  onclick="hideContainer();">
                  <label for="StartEndDates">Start-End Dates</label>
               </td>
            </tr>
            <tr id="noOfTranscationstr">
               <td><label for="noOfTranscations">Number of Transcations</label></td>
               <td>
                  <select name="noOfTranscations" id="noOfTranscations">
                     <option value="1" selected>1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
                     <option value="6">6</option>
                     <option value="7">7</option>
                     <option value="8">8</option>
                     <option value="9">9</option>
                     <option value="10">10</option>
                  </select>
               </td>
            </tr>
            <tr id="startDatetr" style="display:none">
               <td>Start Date:</td>
               <td>
                  <input type="date" name="startdate">
               </td>
            </tr>
            <tr id="endDatetr" style="display:none">
               <td>End Date:</td>
               <td>
                  <input type="date" name="enddate">
               </td>
            </tr>
            <tr>
               <td colspan="2" style="text-align: center;">
                  <input type="submit" name="submit" value="submit">
               </td>
            </tr>
         </tbody>
      </table>
      <script>
         function hideContainer() {
             if (document.getElementById('lastTransaction').checked) {
             	document.getElementById('noOfTranscationstr').style.display = 'block';
             	document.getElementById('endDatetr').style.display = 'none';
             	document.getElementById('startDatetr').style.display = 'none';
             }
             else {
             	document.getElementById('noOfTranscationstr').style.display = 'none';
             	document.getElementById('endDatetr').style.display = 'block';
             	document.getElementById('startDatetr').style.display = 'block';
             }
         
         }
      </script>
      </form>
      </div>
      <%		
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
         %>
      
            	<center>
               		<h1>CUSTOMER DETAILS</h1>
            	</center>
            	
      <table align="center" class="border">
         <tr>
            <th class="row">Transaction ID</th>
            <th class="row">Description</th>
            <th class="row">Date(YYYY-MM-DD)</th>
            <th class="row">Amount</th>
         </tr>
         <%
            try{
            	String AccountID = request.getParameter("accid");
            	int trnNO = Integer.parseInt(request.getParameter("noOfTranscations"));
            	String rdText = request.getParameter("transactionType");
            	
            	PreparedStatement ps;
            	if(rdText.equalsIgnoreCase("lastNoOfTransaction")){
            		ps = con.prepareStatement( "select tran.TransactionID,tran.Description,tran.Transaction_date,tran.Amount from transactions tran join account_table acc on tran.Customer_Id = acc.Customer_ID where `Account_ID`=? LIMIT ?");
            		ps.setString(1,AccountID);
            		ps.setInt(2,trnNO);
            	}else{
            		String StartDate = request.getParameter("startdate");
            		String EndDate = request.getParameter("enddate");
                	
            		ps = con.prepareStatement( "select tran.TransactionID,tran.Description,tran.Transaction_date,tran.Amount from transactions tran join account_table acc on tran.Customer_Id = acc.Customer_ID where `Account_ID`=? AND  tran.Transaction_date Between ? AND ? ");
            		ps.setString(1,AccountID);
            		ps.setString(2,StartDate);
            		ps.setString(3,EndDate);
            		
            	}
            	//out.print(trnNO);
            	ResultSet rs = ps.executeQuery();
            	while (rs.next()) {
            %>
         <tr bgcolor="white">
            <td class="col"><%=rs.getString(1) %></td>
            <td  class="col"><%=rs.getString(2) %></td>
            <td  class="col"><%=rs.getString(3) %></td>
            <td class="col"><%=rs.getString(4) %></td>
         </tr>
         <%
            }
            }catch(Exception e)
            {
            e.printStackTrace();
            
            out.print("<center><a><h3>THIS USER DOES NOT EXISTS</h3></a>");
            out.print("<br>");
            out.print("<br>");
            }
            %>
      </table>
      </div>
   <br>
   <br>
   <br>
   <div class="footer">
   
      <h2 style="color:yellow">About Us</h2>
      <pre>
  FedChoice Bank was founded on 14th June 2016 with 
  the objective of providing with the deatil services based 
  on Retail Banking operations. The retail internet banking 
  of FedChoice Bank offers a plethora product and services, 
  to carter its customers by providing certain animus services
  with an easy volving offersand ways to do the required job 
  without hurdling the process.</pre>  
      <h2 style="color:yellow">Services</h2>
      <pre>
  Retail and Customer Banking
  Personal Internet Banking
  Corporate Internet Banking
  Debit and Credit card
  
  </pre>
	<h2 style="color:yellow">Contact Us</h2>
      <pre>
  Email:customer.service@fedchoice.com
  Contact:9843568456
  Address:Corporate Office, Madame Cana road,
  Mumbai, Maharashtra.
  </pre>
   </div>
   </body>
</html>