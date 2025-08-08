<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Pentagon Space - Updation Form</title>
  <style>
    body {
      background-color: #f4f4f4;
      font-family: Arial, sans-serif;
      text-align: center;
    }
    .form-container {
      background-color: white;
      padding: 30px;
      margin: 50px auto;
      width: 400px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.1);
    }
    h1 {
      color: #4c4c8c;
    }
    h3 {
      color: #a0a0d0;
      margin-bottom: 20px;
    }
    input[type="text"],
    input[type="email"],
    input[type="tel"],
    input[type="password"] {
      width: 90%;
      padding: 10px;
      margin: 8px 0;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    .btn {
      background-color: #4c4c8c;
      color: white;
      padding: 10px 20px;
      margin-top: 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    .login-link {
      display: block;
      margin-top: 15px;
      font-size: 14px;
    }
    .login-link a {
      color: #4c4c8c;
      text-decoration: none;
    }
    .fail{
      color: red;
    }
  </style>
</head>
<body>


  <div class="form-container">
    <h1>Pentagon Space</h1>
    <h3>Update Your Account</h3>
    
    
     <%if(session.getAttribute("student")!=null){ %>
     <%Student s = (Student)session.getAttribute("student"); %>
   

    <form action="Update" method="post">
        <input type="text" name="name"  placeholder="Enter your Name" value="<%=s.getName()%>"><br>
        <input type="tel" name="phone" placeholder="Enter the Phone number" value="<%=s.getPhone()%>"><br>
        <input type="text" name="mail" placeholder="Enter the Mail ID" value="<%=s.getMail()%>"><br>
        <input type="text" name="branch" placeholder="Enter the Branch" value="<%=s.getBranch()%>"><br>
        <input type="text" name="loc" placeholder="Enter the Location" value="<%=s.getLoc()%>"><br>
      <button class="btn" type="submit">Update Account</button>
      <a href="Dashboard.jsp"><button class="btn" type="submit">Back</button></a>
    </form>
    
  </div>
  <%} %>
</body>
</html>