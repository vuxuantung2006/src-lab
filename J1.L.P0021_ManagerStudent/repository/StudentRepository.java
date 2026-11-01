/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author Tuan Tran
 */
public class StudentRepository {

    private List<Student> studentList;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
    }

    //Tìm sinh viên theo mã ID.
    public Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    //Tìm các sinh viên theo tên
    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public boolean isEmpty() {
        return studentList.isEmpty();
    }

    public int getSize() {
        return studentList.size();
    }
}
