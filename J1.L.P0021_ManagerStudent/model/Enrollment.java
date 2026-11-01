/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.ProgrammingLanguage;

/**
 *
 * @author Tuan Tran
 */
public class Enrollment {

    private String semester;
    private ProgrammingLanguage course;

    public Enrollment(String semester, ProgrammingLanguage course) {
        this.semester = semester;
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ProgrammingLanguage getCourse() {
        return course;
    }

    public void setCourse(ProgrammingLanguage course) {
        this.course = course;
    }
}
