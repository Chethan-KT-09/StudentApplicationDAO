package in.pentagon.studentapp.index;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import java.util.Scanner;
public class Signup {
	public static void signup() {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		Student s = new Student();
		System.out.println("<-- Student SignUp -->");
		System.out.println("Enter the Name: ");
		//String name = sc.next();
		//s.setName(name);
		s.setName(sc.next());
		System.out.println("Enter the Phone: ");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the Mail ID: ");
		s.setMail(sc.next());
		System.out.println("Enter the Branch:");
		s.setBranch(sc.next());
		System.out.println("Enter rhe Location: ");
		s.setLoc(sc.next());
		System.out.println("Set a New Password:");
		String password = sc.next();
		System.out.println("Confirm New Password");
		String confirmPassword = sc.next();
		
		if(password.equals(confirmPassword)) {
			s.setPassword(confirmPassword);
			boolean res = sdao.insertStudent(s);
			if(res) {
				System.out.println("Data Added Successfully...!");
			}
			else {
				System.out.println("Failed to Create a Account");
			}
		}
		else {
			System.out.println("Password Mismatch...!");
		}
		
	}

}
