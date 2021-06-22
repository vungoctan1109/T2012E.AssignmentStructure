package assignment.t2012e.view;

import assignment.t2012e.controller.TeacherController;

import java.util.Scanner;

public class TeacherMenu {

    private TeacherController teacherController = new TeacherController();
    private Scanner scanner = new Scanner(System.in);

    public void generateTeacherMenu() {
        while (true) {
            System.out.println("Teacher manager");
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
                    teacherController.create();
                    break;
                case 2:
                    teacherController.showList();
                    break;
                case 3:
                    teacherController.update();
                    break;
                case 4:
                    teacherController.delete();
                    break;
                case 5:
                    teacherController.searchByRollNumber();
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
