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
@WebServlet("/reset")
public class ForgotPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao = new StudentDAOImpl();
//		PrintWriter out = resp.getWriter();
		Student s = sdao.getStudent(Long.parseLong(req.getParameter("phone")), req.getParameter("mail"));
		if(s!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("password"));
				boolean res = sdao.updateStudent(s);
				if(res) {
//					out.println("<h1>Password Updated Successfully!</h1>");
					req.setAttribute("done", "Password Reset successfully!");
					RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
				}
				else {
//					out.println("<h1>Failed to Update the Password!</h1>");
					req.setAttribute("error", "Failed to resetpassword!");
					RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
					rd.forward(req, resp);
				}
			}
			else {
//				out.println("<h1>Password mismatched!</h1>");
				req.setAttribute("error", "Password Mismatch!");
				RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
		
		}
	}
	

}
