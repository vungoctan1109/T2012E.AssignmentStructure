package assignment.t2012e.controller;

import assignment.t2012e.entity.Student;
import assignment.t2012e.model.StudentModel;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    private Scanner scanner = new Scanner(System.in);
    private StudentModel studentModel = new StudentModel();

    public void create() {

        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please enter student's roll number: ");
        String rollNumber = scanner.nextLine();
        student.setRollNumber(rollNumber);
        System.out.println("Please enter student's full name: ");
        String fullName = scanner.nextLine();
        student.setFullName(fullName);
        System.out.println("Please enter student's email: ");
        String email = scanner.nextLine();
        student.setEmail(email);
        System.out.println("Please enter student's phone: ");
        String phone = scanner.nextLine();
        student.setPhone(phone);
        if (studentModel.save(student)) {
            System.out.println("Action success.");
        } else {
            System.out.println("Action failed.");
        }
    }

    public void showList() {
        ArrayList<Student> list = studentModel.findAll();
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
        System.out.println("Please enter student's roll number: ");
        String rollNumber = scanner.nextLine();
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            System.err.println("Student is not found.");
        } else {
            System.out.printf("Found a student with information: %s\n", student.toString());
        }

    }

    public void update() {
        System.out.println("Please enter roll number to update: ");
        String rollNumber = scanner.nextLine();
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            System.err.println("Student is not found.");
        } else {
            System.out.printf("Found a student with information: %s\n", student.toString());
            Student updateStudent = new Student();
            System.out.println("Please enter student's full name: ");
            String fullName = scanner.nextLine();
            updateStudent.setFullName(fullName);
            System.out.println("Please enter student's email: ");
            String email = scanner.nextLine();
            updateStudent.setEmail(email);
            System.out.println("Please enter student's phone: ");
            String phone = scanner.nextLine();
            updateStudent.setPhone(phone);
            if (studentModel.update(rollNumber, updateStudent)) {
                System.out.println("Update success.");
            } else {
                System.out.println("Action failed.");
            }
        }
    }

    public void delete() {
        System.out.println("Please enter roll number to delete: ");
        String rollNumber = scanner.nextLine();
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            System.err.println("Student is not found.");
        } else {
            System.out.printf("Found a student with information: %s\n", student.toString());
            System.out.println("Are you sure you want to delete this student (y/n)?");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                if (studentModel.delete(rollNumber)) {
                    System.out.println("Delete success.");
                } else {
                    System.out.println("Delete failed.");
                }
            }
        }
    }
}

