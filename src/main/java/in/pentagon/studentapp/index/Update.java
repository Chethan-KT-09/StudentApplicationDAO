package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;


public class Update {
    public static void update(Student s) {
        Scanner sc = new Scanner(System.in);
        StudentDAO sdao = new StudentDAOImpl();
        System.out.println("<-- Update Account -->");
        int choice = 0;
        do {
            System.out.println("Enter the field to be updated: ");
            System.out.println("1. Name");
            System.out.println("2. Phone");
            System.out.println("3. Mail ID");
            System.out.println("4. Branch");
            System.out.println("5. Location");
            System.out.println("6. Go back to dashboard");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    s.setName(sc.next());
             
                    break;

                case 2:
                    System.out.print("Enter new phone number: ");
                    s.setPhone(sc.nextLong());
                    break;

                case 3:
                    System.out.print("Enter new email: ");
                    s.setMail(sc.next());
                    
                    break;

                case 4:
                    System.out.print("Enter new branch: ");
                    s.setBranch(sc.next());
                    
                    break;

                case 5:
                    System.out.print("Enter new location: ");
                    s.setLoc(sc.next());
 
                    break;

                case 6:
                    System.out.println("Dashboard Loading...!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

    
    }
}
