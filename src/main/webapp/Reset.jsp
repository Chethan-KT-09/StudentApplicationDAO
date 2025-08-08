<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pentagon Space - Reset Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f2ff;
            text-align: center;
        }
        h1 {
            color: #4b0082;
        }
        h2 {
            color: #4169e1;
        }
        form {
            background-color: #ffffff;
            display: inline-block;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.2);
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 300px;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn-reset {
            background-color: #28a745;
            color: white;
            padding: 10px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn-back {
            background-color: #007bff;
            color: white;
            padding: 10px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-left: 10px;
        }
        .error{
        color:red;
        }
    </style>
</head>
<body>
    <h1>Pentagon Space</h1>
    <h2>Reset Password</h2>
    <%if(request.getAttribute("error")!=null){ %>
   <h3 class="error"><%=request.getAttribute("error") %></h3>
     <%} %>

    <form action="reset" method="post">
        <input type="tel" name="phone" placeholder="Enter the Phone number" required><br>
        <input type="text" name="mail" placeholder="Enter the Mail ID" required><br>
        <input type="password" name="password" placeholder="Enter the New Password" required><br>
        <input type="password" name="confirm" placeholder="Confirm the New Password" required><br>

        <input type="submit" value="Reset Password" class="btn-reset">
        <button type="button" class="btn-back" onclick="location.href='Login.jsp'">Back</button>
    </form>
</body>
</html>