package model;

import constant.Message;
import constant.ProgrammingLanguage;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private List<Enrollment> enrollments; // Thay thế semester & courseName cũ

    public Student(String id, String studentName) {
        this.id = id;
        this.studentName = studentName;
        this.enrollments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    // Phuong thuc them mot dang ky hoc moi, neu bi trung se nem ra ngoai le (exception)
    public void addEnrollment(Enrollment e) throws Exception {
        if (isDuplicated(e.getSemester(), e.getCourse(), -1)) {
            throw new Exception(Message.ERROR_DUPLICATE);
        }
        enrollments.add(e);
    }

    // Phuong thuc kiem tra xem hoc ky va mon hoc da bi trung lap hay chua (co the bo qua vi tri chi dinh boi ignoreIndex)
    public boolean isDuplicated(String semester, ProgrammingLanguage course, int ignoreIndex) {
        for (int i = 0; i < enrollments.size(); i++) {

            if (i == ignoreIndex) {
                continue;
            }
            Enrollment e = enrollments.get(i);

            // So sanh hoc ky (khong phan biet hoa thuong) va mon hoc
            if (e.getSemester().equalsIgnoreCase(semester)
                    && e.getCourse() == course) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Student t) {
        return this.studentName.compareTo(t.studentName);
    }
}
