<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,com.cestar.model.Client" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<%

   //List<Employee>  empz = (List)session.getAttribute("empz_list");
	List<Client>  clients = (List)session.getAttribute("clients_list");
  
 
%>
<h2 style="margin-top: 5%; text-align:center"> Welcome to Shipping App</h2>
<h3 style="text-align:center"> Manage here the information related to your shipping clients</h3>
<div style="margin-top: 5%; margin-left: 5%; margin-right: 5%">
<table  class="table table-striped" >

<tr>
<th>Client ID</th>
<th>Name</th>
<th>Contact</th>
<th>Item Shipped</th>
<th>Date received</th>
<th>Date sent</th>
<th>Edit</th>
<th>Delete</th>
</tr>


<%

  for(int i=0;i<clients.size();i++){
	  
	  
	  out.print("<tr>");
	  
	 
	  
	  out.print("<td>"+clients.get(i).getId()+"</td>");
	  
	  out.print("<td>"+clients.get(i).getName()+"</td>");
	  
	  out.print("<td>"+clients.get(i).getContact()+"</td>");
	  
	  out.print("<td>"+clients.get(i).getItemShipped()+"</td>");
	  
	  out.print("<td>"+clients.get(i).getDate_received()+"</td>");
	  
	  out.print("<td>"+clients.get(i).getDate_shipped()+"</td>");
	  
	  //out.print("<td> <a class='btn btn-primary' href='edit?e_id="+empz.get(i).getId()+"'' role='button'>Edit....</a> </td>");
	  out.print("<td> <a class='btn btn-secondary' href='edit?c_id="+clients.get(i).getId()+"'' role='button'>Edit....</a> </td>");
	  out.print("<td> <a class='btn btn-danger' href='delete?c_id="+clients.get(i).getId()+"'' role='button'>Delete</a> </td>");
	  out.print("</tr>");
  }



%>

</table>
</div>
<br>
<div class="d-grid col-3 mx-auto">
  <a class="btn btn-info" href="insert.jsp" role="button">Insert Client</a>
</div>
</body>
</html>