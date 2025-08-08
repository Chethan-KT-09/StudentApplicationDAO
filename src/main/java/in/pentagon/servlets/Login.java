package in.pentagon.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")

public class Login extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		StudentDAO sdao =  new StudentDAOImpl();//Studentdao obj
		//creation of session object- [new]
		HttpSession session = req.getSession(true);
		
//		PrintWriter out = resp.getWriter(); 
		
		
		Student s = sdao.getStudent(req.getParameter("mail"), req.getParameter("password"));
	        if (s!=null) {
//	            out.println("<h1>Login Successful</h1>");
	        	session.setAttribute("student",s);
				req.setAttribute("success","Login successfully");
				RequestDispatcher rd =req.getRequestDispatcher("Dashboard.jsp");
				rd.forward(req, resp);

	        } else {
//	            out.println("<h1>Invalid Email or Password</h1>");
				req.setAttribute("error","Failed to login!!");
				RequestDispatcher rd =req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);

			}
		
			
		}
		

		
	}