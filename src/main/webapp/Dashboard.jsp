<%@page import="jakarta.servlet.RequestDispatcher"%>
<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <style>
  body {
  background-image: url("images/desktop-wallpaper-virat-kohli-ipl-posted-by-ryan-simpson-virat-kohli-rcb.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size :100%;
  
}
    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: green;
      color: whitesmoke;
      padding: 10px 20px;
    }
    header .nav-left span {
      font-weight: bold;
    }

    header .nav-right a {
      color: whitesmoke;
      margin-left: 15px;
      text-decoration: none;
    }
    .back-btn {
      margin-left: 15px;
      padding: 5px 10px;
      background-color: red;
      border: none;
      color: whitesmoke;
      cursor: pointer;
      border-radius: 3px;
    }
    main {
      padding: 20px;
      text-align: justify;
    }

    h1 {
      margin-bottom: 20px;
    }

    .view-data {
      max-width: 800px;
      border: none;
      padding: 0px;
      border-radius: 5px;
      text-align: left;
    }

    .search-bar {
      margin-bottom: 20px;
    }

    .search-bar input[type="text"] {
      padding: 8px;
      width: 60%;
      max-width: 300px;
      border: 1px solid black;
      border-radius: 3px;
    }

    .search-bar button {
      padding: 8px 12px;
      margin-left: 5px;
      border: none;
      background-color: skyblue;
      color: whitesmoke;
      cursor: pointer;
      border-radius: 3px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    table th, table td {
      padding: 10px;
    }
  </style>
</head>
<body>



	<%if(request.getAttribute("student")!=null){ %>
	<%Student s =(Student)request.getAttribute("student");%>







  <header>
    <div class="nav-left">
      <h3> Welcome <%= s.getName()%> </h3>
    </div>
    <div class="nav-right">
      <a href="#">Home</a>
      <a href="#">About</a>
      <a href="#">Contact</a>
      <a href="Update">Update</a>
      <a class="back-btn" href="Login.jsp">Logout</a>
    </div>
  </header>
  <main>
    <center><h1>Dashboard</h1></center>
    <div class="data">
      <section class="view-data">
      <h2>View Your Data</h2>
      </section>
    </div>
      <table>
          <tr>
            <th>Name:  </th>
            <th>Phone: </th>
            <th>Mail ID: </th>
            <th>Branch: </th>
            <th>Location: </th>
          </tr>
          <tr>
            <td><%=s.getName()%></td>
			<td><%=s.getPhone()%></td>
			<td><%=s.getMail()%></td>
			<td><%=s.getBranch()%></td>
			<td><%=s.getLoc()%></td>
          </tr>
      </table>
    <div class="search-bar">
        <h2>Search User</h2>
        Enter the Student Name here <input type="text">
        <button>Search</button>
      </div>
      <table>
     	 <tr>
            <th>Name:  </th>
            <th>Phone: </th>
            <th>Mail ID: </th>
            <th>Branch: </th>
            <th>Location: </th>
          </tr>
      </table>
 
  
  </main>
  
 <%}
  else{
		request.setAttribute("error","Session experied!");
		RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
  		rd.forward(request, response);
  }%>
</body>
</html>