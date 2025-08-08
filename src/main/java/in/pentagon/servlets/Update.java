package in.pentagon.servlets;

import java.io.IOException;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Update")

public class Update extends HttpServlet{
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			StudentDAO sdao=new StudentDAOImpl();
			Student s =new Student(); 

			System.out.println("<---Update Account--->");
			
	                    s.setName(req.getParameter("name"));
	                    s.setPhone(Long.parseLong(req.getParameter("phone")));
	                	s.setMail(req.getParameter("mail"));
	            		s.setBranch(req.getParameter("branch"));
	            		s.setLoc(req.getParameter("loc"));

	            		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
	            			s.setPassword(req.getParameter("password"));
	            			boolean  res = sdao.updateStudent(s);
	            			if(res) {
//	            				out.println("<h1> Data added successfully </h1>");
	            				
	            				req.setAttribute("success","WELL DONE New DAta Updated  successfully");
	            				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
	            				rd.forward(req, resp);
	            				
	            			}else {
//	            				out.println("<h1>Failed to signup </h1>");
	            				req.setAttribute("failed","Failed to update data");
	            				RequestDispatcher rd =req.getRequestDispatcher("Update.jsp");
	            				rd.forward(req, resp);			}
	            		}else {
	            			req.setAttribute("error","Password mismatch!");
	            			RequestDispatcher rd =req.getRequestDispatcher("Update.jsp");
	            			rd.forward(req, resp);
	            
	            		}
		}
	}