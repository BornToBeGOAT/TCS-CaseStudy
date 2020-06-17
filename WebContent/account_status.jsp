<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %>
      <%@ page import="java.io.*" %>
      <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="com.model_class.accountstatusmodel"%>
<%@page import="java.util.Iterator"%> 
      
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retail Banking System</title>

<link rel="stylesheet" href="createcustomer.css">

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
      <a href="">Account Status</a>
       <a href="Account_Statement">Account statement</a>
    </div>
  </div>
 
  <a href="logout.jsp">Log out</a>
 </div>
 <br>
 <br>
 <br>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
body{
     font-family:sans-serif;
     font-size:1em;
    }
table{
      width:80%;
     }    
table,th,td{
      border:1px solid black;
      border-collapse:collapse;
      opacity:1.0;
       background-color:lightgray;
     }    
th,td{
      padding:10px;
      text-align:center;
     }  
th{
   background-color:yellow;
   color:black;
   
  }   
  
   button {
  padding: 10px;
  text-align: left;
  background-color:yellow;
  color: black;
}
</style>
</head>
<body bgcolor="lightgray">
	<%		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
	%>
<tr>
      <td colspan="10"><center><h1>ACCOUNT STATUS</h1></td></center>
      </tr>
<table align="center">
      <tr>
           <th>Customer ID</th>
           <th>Account ID</th>
           <th>Account Type</th>
           <th>Account Status</th>
           <th>Message</th>
           <th>Last Updated</th>      
        <th>Operation</th>
       </tr>



<%
try{
	ArrayList<accountstatusmodel> accountstatusmodelData = (ArrayList)request.getAttribute("data");
	if(request.getAttribute("data") != null)  // Null check for the object
	{
		Iterator<accountstatusmodel> iterator = accountstatusmodelData.iterator();  // Iterator interface
		
		while(iterator.hasNext())  // iterate through all the data until the last record
		{
			accountstatusmodel empDetails = iterator.next(); //assign individual employee record to the employee class object
		%>
		<tr bgcolor="white">
			<td><%=empDetails.getCustomerId()%></td>
			<td><%=empDetails.getAccountId() %></td>
			<td ><%=empDetails.getAccountType() %></td>
			<td><%=empDetails.getAccountStatus() %></td>
			<td><%=empDetails.getMessage() %></td>
			<td><%=empDetails.getLastUpdated() %></td>
			<td><%out.print("<center><a href='Accoun_Status'><h3>refresh</h3></a>"); %></td>
		</tr>

		<%
		}
	}
	
}catch(Exception e)
{
	e.printStackTrace();

}
%>


</table>
<br>
<br>


<center><button type="button" onClick="refreshPage()" >Refresh the List</button></center>
<script>
function refreshPage(){
    window.location.reload();
} 

</script>

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