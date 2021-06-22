package assignment.t2012e.model;

import assignment.t2012e.entity.Teacher;

import java.util.ArrayList;

public class TeacherModel {
    private ArrayList<Teacher> list;

    {
        list = new ArrayList<>();
        list.add(new Teacher("T001", "Tan", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Teacher("T002", "Ta", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Teacher("T003", "Tang", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Teacher("T004", "Tun", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Teacher("T005", "Ton", "vntan1109@gmail.com", "49385349563459"));
        list.add(new Teacher("T006", "Tien", "vntan1109@gmail.com", "49385349563459"));
    }

    public boolean save(Teacher obj) {
        list.add(obj);
        return true;
    }

    public ArrayList<Teacher> findAll() {
        return list;
    }

    public Teacher findById(String id) {
        Teacher obj = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)) {
                obj = list.get(i);
                break;
            }
        }
        return obj;
    }

    public boolean update(String id, Teacher updateObj) {
        Teacher existingTeacher = findById(id);
        if (existingTeacher == null) {
            return false;
        }
        existingTeacher.setPhone(updateObj.getPhone());
        existingTeacher.setEmail(updateObj.getEmail());
        existingTeacher.setFullName(updateObj.getFullName());
        return true;
    }

    public boolean delete(String id) {
        Teacher existingTeacher = findById(id);
        if (existingTeacher == null) {
            return false;
        }
        list.remove(existingTeacher);
        return true;
    }
}
