package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Delete {
	public static void deleteStudent(int id) {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		
		boolean res = sdao.deleteStudent(id);
		
		if(res) {
			System.out.println("Student Data Deleted Successfully...!");
		}
		else {
			System.out.println("Failde to delete the data");
		}
		
	}
	

}
