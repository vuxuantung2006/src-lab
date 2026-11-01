/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constant.ProgrammingLanguage;

/**
 *
 * @author Tuan Tran
 */
public class StudentDTO {

    private String id;
    private String studentName;
    private String semester;
    private ProgrammingLanguage courseName;
    private int No;

    public StudentDTO(String id, String studentName, String semester, ProgrammingLanguage courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public StudentDTO() {
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ProgrammingLanguage getCourseName() {
        return courseName;
    }

    public void setCourseName(ProgrammingLanguage courseName) {
        this.courseName = courseName;
    }

}
