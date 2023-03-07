<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="com.cestar.model.Client" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body bgcolor='#F5CBA7'>
<%  

  //Employee emp = (Employee)session.getAttribute("emp_from_db");
	Client client = (Client)session.getAttribute("client_from_db");
 //  out.print(emp);
   
   // set the current id of employee as a session attribute 
   // we will be using this id as old Id of Employee in update method
   
   session.setAttribute("curr_id",client.getId());
%>

<div style="margin-top: 2%;">
	
	<h4 style="text-align: center;'">Edit Client Information</h3> 
	<br>
    <form action="update" style="margin-left:400px;">
  	<div class="col-sm-5">
    <label for="id" class="form-label">Client Id</label>
    <input type="text" class="form-control" id="id" name="id" value="<%=client.getId()  %>">
   
  </div>
  <br>
  
  <div class="col-sm-5">
    <label for="name" class="form-label">Client Name</label>
    <input type="text" class="form-control" id="name" name="name" value="<%=client.getName() %>">
   
  </div>
  <br>
  
  <div class="col-sm-5">
    <label for="con" class="form-label">Client Contact</label>
    <input type="text" class="form-control" id="con" name="con" value="<%=client.getContact()  %>">
   
  </div>
  <br>
  
  <div class="col-sm-5">
    <label for="item" class="form-label">Item shipped</label>
    <input type="text" class="form-control" id="item" name="item" value="<%=client.getItemShipped()  %>">
   
  </div>
  <br>
  
  <div class="col-sm-5">
    <label for="date_r" class="form-label">Date item received</label>
    <input type="date" class="form-control" id="date_r" name="date_r" value="<%=client.getDate_received()  %>">
   
  </div>
  <br>
  
  <div class="col-sm-5">
    <label for="date_s" class="form-label">Date item shipped</label>
    <input type="date" class="form-control" id="date_s" name="date_s"  value="<%=client.getDate_shipped()%>">
   
  </div>
  
  <br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>