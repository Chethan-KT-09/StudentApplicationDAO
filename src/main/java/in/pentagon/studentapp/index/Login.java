package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
public class Login {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		StudentDAOImpl sdao = new StudentDAOImpl();
		System.out.println("<-- Login Page -->");
		System.out.println("enter the Mail ID");
		String mail = sc.next();
		System.out.println("Enter the Password");
		String pass = sc.next();
		Student a = sdao.getStudent(mail,pass);
		if(a!=null) {
			System.out.println("Login Successfull...! Welcome "+a.getName());
			do {
				System.out.println("1. View Data");
				System.out.println("2. Search Users");
				System.out.println("3. Update Account");
				System.out.println("4. reset Password");
				System.out.println("5. Back to main menu");
				if(a.getId()==2) {  //admin
					System.out.println("6. View All Users");
					System.out.println("7. Delete the user");
				}
				choice = sc.nextInt();
				switch (choice) {
				case 1: System.out.println(a);
				    break;
				case 2: System.out.println("Enter the Student Name:");
				        String name=sc.next();
				        ArrayList<Student> sL=sdao.getStudent(name);
				        for(Student s3 : sL) {
				        	System.out.println("Student id: "+s3.getId());
				        	System.out.println("Student Name: "+s3.getName());
				        	System.out.println("Student Branch: "+s3.getBranch());
				        	System.out.println("Student Location: "+s3.getLoc());	
				        }  
					break;
				case 3: Update.update(a);
					break;
				case 4: Password.reset(a);
					break;
				case 5:System.out.println("Going back to main menu...!");
					break;
				case 6: System.out.println("Our Users...!");
				        ArrayList<Student> sl=sdao.getStudent();
				        
					break;
				case 7: System.out.println("Enter the ID to delete");
				        int del = sc.nextInt();
					   Delete.deleteStudent(del);
					break;
				default : System.out.println("Invalid Choice... try again!");
				}
			}while(choice!=5);
		}
		else {
			System.out.println("Failde to Login!");
		}
		
	}

}
