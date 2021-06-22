package assignment.t2012e.model;

import assignment.t2012e.entity.Student;

import java.util.ArrayList;

public class StudentModel {
    private ArrayList<Student> list;

    {
        list = new ArrayList<>();
        list.add(new Student("A001", "Tan", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Student("A002", "Ta", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Student("A003", "Tang", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Student("A004", "Tun", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Student("A005", "Ton", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Student("A006", "Tien", "vntan1109@gmail.com", "49385349563459"));
    }

    public boolean save(Student obj) {
        list.add(obj);
        return true;
    }

    public ArrayList<Student> findAll() {
        return list;
    }

    public Student findById(String id) {
        Student obj = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)) {
                obj = list.get(i);
                break;
            }
        }
        return obj;
    }

    public boolean update(String id, Student updateObj) {
        Student existingStudent = findById(id);
        if (existingStudent == null) {
            return false;
        }
        existingStudent.setPhone(updateObj.getPhone());
        existingStudent.setEmail(updateObj.getEmail());
        existingStudent.setFullName(updateObj.getFullName());
        return true;
    }

    public boolean delete(String id) {
        Student existingStudent = findById(id);
        if (existingStudent == null) {
            return false;
        }
        list.remove(existingStudent);
        return true;
    }
}
