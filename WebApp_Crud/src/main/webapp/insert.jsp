<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="./resources/css/style.css">
</head>
<body>

<div style="margin-top: 4%">
	
	<h4 style="text-align: center;">Insert new client into database</h4>
	<br>
    <form action="insert" style="margin-left:400px;">
  
  <div class="col-sm-5">
    <label for="id" class="form-label">Client Id</label>
    <input type="text" class="form-control" id="id" name="id">
   
  </div>
  <div class="col-sm-5">
    <label for="name" class="form-label">Client Name</label>
    <input type="text" class="form-control" id="name" name="name">
   
  </div>
  
  <div class="col-sm-5">
    <label for="con" class="form-label">Client Contact</label>
    <input type="text" class="form-control" id="con" name="con">
   
  </div>
  
  <div class="col-sm-5">
    <label for="item" class="form-label">Item shipped</label>
    <input type="text" class="form-control" id="item" name="item">
   
  </div>
  
  <div class="col-sm-5">
    <label for="date_r" class="form-label">Date item received</label>
    <input type="date" class="form-control" id="date_r" name="date_r">
   
  </div>
  <div class="col-sm-5">
    <label for="date_s" class="form-label">Date item shipped</label>
    <input type="date" class="form-control" id="date_s" name="date_s">
   
  </div>

  <br>
  <button type="submit" class="btn btn-success">Insert Client</button>
</form>

</div>
   

</body>
</html>