package in.pentagon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//creating the object of POJO class
		Student s = new Student();
		//creating reference object of StudentDAO
		StudentDAO sdao = new StudentDAOImpl();
		//creating PrintWriter class object
		//PrintWriter out = resp.getWriter();
		//collecting the data from the UI
		//String name = req.getParameter("name");
		//s.setName(name);
		s.setName(req.getParameter("name"));
		
		//String s_p = req.getParameter("phone");
		//long phone = Long.parseLong(s_p);
		//s.setPhone(phone);
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res = sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Account Created Successfully!<h1>");
				req.setAttribute("success", "Account Created successfully!");
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
			else {
				//out.println("<h1>Failed to Signup!<h1>");
				req.setAttribute("error", "Failed to Signup!");
				RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Password mismatch!<h1>");
			req.setAttribute("error", "Password Mismatch!");
			RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}
		
	}

}
