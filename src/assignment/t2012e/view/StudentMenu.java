package assignment.t2012e.view;

import assignment.t2012e.controller.StudentController;

import java.util.Scanner;

public class StudentMenu {

    private StudentController studentController = new StudentController();
    private Scanner scanner = new Scanner(System.in);

    public void generateStudentMenu() {
        while (true) {
            System.out.println("Student manager");
            System.out.println("---------------------");
            System.out.println("1. Create new.");
            System.out.println("2. Show list.");
            System.out.println("3. Update.");
            System.out.println("4. Delete.");
            System.out.println("5. Search by RollNumber.");
            System.out.println("0. Exit program.");
            System.out.println("---------------------");
            System.out.println("Please enter your choice (0-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    studentController.create();
                    break;
                case 2:
                    studentController.showList();
                    break;
                case 3:
                    studentController.update();
                    break;
                case 4:
                    studentController.delete();
                    break;
                case 5:
                    studentController.searchByRollNumber();
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
                default:
                    break;
            }
            if (choice == 0) {
                break;
            }
            scanner.nextLine();
        }
    }
}
