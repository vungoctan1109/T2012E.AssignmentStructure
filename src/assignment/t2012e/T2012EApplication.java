package assignment.t2012e;


import assignment.t2012e.view.StudentMenu;
import assignment.t2012e.view.TeacherMenu;

import java.util.Scanner;


public class T2012EApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentMenu menuStudent = new StudentMenu();
        TeacherMenu menuTeacher = new TeacherMenu();
        System.out.println("Choose one of two management programs: ");
        System.out.println("1. Student Manager.");
        System.out.println("2. Teacher Manager.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                menuStudent.generateStudentMenu();
                break;
            case 2:
                menuTeacher.generateTeacherMenu();
                break;
        }

    }
}



