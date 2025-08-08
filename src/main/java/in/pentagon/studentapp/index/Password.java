package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
	public static void reset(Student s) {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		System.out.println("Enter the pPhone Number: ");
		long phone = sc.nextLong();
		
		System.out.println("Enter the Mail ID: ");
		String mail = sc.next();
		
		if(s.getPhone()==phone && s.getMail().equals(mail)) {
			System.out.println("Set the new Password: ");
			String pass = sc.next();
			
			System.out.println("Confirm the Password: ");
			String confirm = sc.next();
			
			if(pass.equals(confirm)) {
				s.setPassword(pass);
				boolean res = sdao.updateStudent(s);
				if(res) {
					System.out.println("Update Successfull...!");
				}
				else {
					System.out.println("Failde to update password");
				}
			}
			else {
				System.out.println("Incorrect phone number or mail id");
			}
		}
		}
		public static void forgot() {
			Scanner sc = new Scanner(System.in);
			StudentDAO sdao = new StudentDAOImpl();
			
			System.out.println("Enter the Phone Number: ");
			long phone = sc.nextLong();
			System.out.println("Enter the Mail ID: ");
			String mail = sc.next();
			Student a = sdao.getStudent(phone, mail);
			
			if(a!=null) {
				System.out.println("Proceeding to Password Reset...");
				reset(a);
			}
			else {
				System.out.println("User not varified by given Mail ID and Paasword...!");
			}
		
		
	}

}
