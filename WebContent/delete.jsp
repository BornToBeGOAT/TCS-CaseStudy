<%@page import="com.util.*"%>
<%@page import="java.sql.*"%>
<%
int ssnid = Integer.parseInt(request.getParameter("Customer SSN ID"));
int cid = Integer.parseInt(request.getParameter("Customer ID"));
Connection conn= connection_util.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
%>
<%
try{
ps=conn.prepareStatement("SELECT *  FROM `customer_table` WHERE `Customer_ID` = ? OR `Customer_SSN_ID` = ?");
ps.setInt(1,cid);
ps.setInt(2,ssnid);
rs=ps.executeQuery();


while(rs.next()){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retail Banking System</title>
<style>
* {
  box-sizing: border-box;
}


body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}


.header {
  padding: 10px;
  text-align: left;
  background: black;
  color: yellow;
}


.header h1 {
  font-size: 40px;
}

.navbar {
  overflow: hidden;
  background-color: yellow;
  font-family: Arial;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: black;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit; 
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: lightgray;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: lightgray;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
.main {
 padding: 80px;
 background-color: lightgray;
}

.footer {
  padding: 10px;
  text-align: left;
  background-color: black;
  color: lightgray
}

@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
.main h2{
	text-align:center;
	
}
.main h4{
	text-align:center;
}
.main p{
	font-size:smaller;
	text-align:right;
}
form { 
	margin: 0 auto; 
	width:400px;
}
.button{
	text-align:center;
}
#view{
	background-color:black;
	color:white;
	
}


</style>
</head>
<body>
	<div class="header">
  <h1>FedChoice Bank</h1>
</div>

<div class="navbar">
  <a href="homepage.html">Home</a>
  
  <div class="dropdown">
    <button class="dropbtn">Customer Management
     </button>
    <div class="dropdown-content">
      <a href="createcustomer.jsp">Create Customer</a>
      <a href="updatesearch.jsp">Update Customer</a>
      <a href="deletesearch.jsp">Delete Customer</a>
      
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
      <a href="#">Withdrawl Money</a>
      <a href="#">Transfer Money</a>
    </div>
  </div>
  
 <div class="dropdown">
    <button class="dropbtn">Status Details
     </button>
    <div class="dropdown-content">
      <a href="#">Customer Status</a>
      <a href="#">Account Status</a>
       <a href="#">Account statement</a>
    </div>
  </div>
 
  <a href="#">Log out</a>
 </div>
 <div class="main">
 	<h2>Update Customer</h2>
 	<div class="register">
 	<form action="<%= request.getContextPath() %>/deletecustomer" method="post">
 	<table>
 			<tr>
 				<td>
 					<label class="required">Customer SSN ID:</label>
 				</td>
 				<td>
 					<%=rs.getString("Customer_SSN_ID") %>
 					</td>
 					<td>
 					<input type="hidden" name="Customer SSN ID" value=<%=rs.getString("Customer_SSN_ID") %>>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<label class="required">Customer ID:</label>
 				</td>
 				<td>
 					<%=rs.getString("Customer_ID") %>
 					</td>
 					<td>
 					<input type="hidden" name= "Customer ID" value=<%=rs.getString("Customer_ID") %>>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<label class="required">Customer Name:</label>
 				</td>
 				<td>
 					<%=rs.getString("Customer_Name") %>
 				</td>
 				<td>
 				<input type="hidden" name= "name" value=<%=rs.getString("Customer_Name") %>>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<label class="required">Address Line1:</label>
 				</td>
 				<td>
 					<%=rs.getString("Address_Line1") %>
 				</td>
 				<td>
 				<input type="hidden" name= "address1" value=<%=rs.getString("Address_Line1") %>>
 				</td>
 			</tr>
 			<tr>
 				
 				<td>
 					<label class="required">Address Line2:</label>
 				</td>
 				<td>
 					<%=rs.getString("Address_Line2") %>
 				</td>
 				<td>
 				<input type="hidden" name= "address2" value=<%=rs.getString("Address_Line2") %>>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<label class="required">Customer Age:</label>
 				</td>
 				<td>
 					<%=rs.getString("Age") %>
 				</td>
 				<td>
 				<input type="hidden" name= "age" value=<%=rs.getString("Age") %>>
 				</td>
 			</tr>
 			</table>
 		<br><br>
 			<input type=submit value="Confirm Delete">
</form>
 	

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
<%
}
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
>
