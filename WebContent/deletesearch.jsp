<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
 	<h2>Search Customer</h2>
 	<p>*Enter one of the detail should be required</p>
 	<div class="search">
 		<form method="post" name= "Form" action="<%= request.getContextPath() %>/deletesearch"   >
 		<table>
 			<tr>
 				<td>
 					<label class="required">Enter SSN ID:</label>
 				</td>
 				<td>
 					<input type="number" id="Customer SSN ID" name="Customer SSN ID" value="0">
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<label class="required">Enter Customer ID:</label>
 				</td>
 				<td>
 					<input type="number" id="Customer ID" name="Customer ID" value="0">
 				</td>
 			</tr>
		</table>
			<br>
			<br>
			<div class=button>
				<input type="submit" value="View" id="view" >
			</div>
			
		</form>
  	</div>
 	
  </div>


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

