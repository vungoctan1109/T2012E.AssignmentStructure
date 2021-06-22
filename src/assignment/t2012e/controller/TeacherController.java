package assignment.t2012e.controller;

import assignment.t2012e.entity.Teacher;
import assignment.t2012e.model.TeacherModel;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {

    private Scanner scanner = new Scanner(System.in);
    private TeacherModel teacherModel = new TeacherModel();

    public void create() {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        System.out.println("Please enter teacher's roll number: ");
        String rollNumber = scanner.nextLine();
        teacher.setRollNumber(rollNumber);
        System.out.println("Please enter teacher's full name: ");
        String fullName = scanner.nextLine();
        teacher.setFullName(fullName);
        System.out.println("Please enter teacher's email: ");
        String email = scanner.nextLine();
        teacher.setEmail(email);
        System.out.println("Please enter teacher's phone: ");
        String phone = scanner.nextLine();
        teacher.setPhone(phone);
        if (teacherModel.save(teacher)) {
            System.out.println("Action success.");
        } else {
            System.out.println("Action failed.");
        }
    }

    public void showList() {
        ArrayList<Teacher> list = teacherModel.findAll();
        System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s\n",
                "", "Rollnumber", "",
                "", "Fullname", "",
                "", "Email", "",
                "", "Phone", "");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void searchByRollNumber() {
        System.out.println("Please enter Teacher's roll number: ");
        String rollNumber = scanner.nextLine();
        Teacher teacher = teacherModel.findById(rollNumber);
        if (teacher == null) {
            System.err.println("Teacher is not found.");
        } else {
            System.out.printf("Found a Teacher with information: %s\n", teacher.toString());
        }

    }

    public void update() {
        System.out.println("Please enter roll number to update: ");
        String rollNumber = scanner.nextLine();
        Teacher teacher = teacherModel.findById(rollNumber);
        if (teacher == null) {
            System.err.println("Teacher is not found");
        } else {
            System.out.printf("Found a Teacher with information: %s\n", teacher.toString());
            Teacher updateTeacher = new Teacher();
            System.out.println("Please enter Teacher's full name: ");
            String fullName = scanner.nextLine();
            updateTeacher.setFullName(fullName);
            System.out.println("Please enter Teacher's email: ");
            String email = scanner.nextLine();
            updateTeacher.setEmail(email);
            System.out.println("Please enter Teacher's phone: ");
            String phone = scanner.nextLine();
            updateTeacher.setPhone(phone);
            if (teacherModel.update(rollNumber, updateTeacher)) {
                System.out.println("Update success.");
            } else {
                System.out.println("Update failed.");
            }
        }
    }

    public void delete() {
        System.out.println("Please enter roll number to delete: ");
        String rollNumber = scanner.nextLine();
        Teacher teacher = teacherModel.findById(rollNumber);
        if (teacher == null) {
            System.err.println("Teacher is not found");
        } else {
            System.out.printf("Found a Teacher with information: %s\n", teacher.toString());
            System.out.println("Are you sure you want to delete this Teacher (y/n)?");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                if (teacherModel.delete(rollNumber)) {
                    System.out.println("Delete success.");
                } else {
                    System.out.println("Delete failed.");
                }
            }
        }
    }

}

