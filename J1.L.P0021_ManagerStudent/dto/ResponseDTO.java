/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Tuan Tran
 */
public class ResponseDTO implements Comparable<ResponseDTO> {
    
    private String id;
    private String studentName;
    private String semester;
    private String courseName;
    private int No;
    private int total;
    // Getters and Setters

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
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getNo() {
        return No;
    }
    
    public void setNo(int No) {
        this.No = No;
    }

    @Override
    public int compareTo(ResponseDTO t) {
        return this.studentName.compareTo(t.studentName);
    }

    @Override
    public String toString() {
        return String.format("|%5s|%15s|%10s|%15s|", No, studentName,
                semester, courseName);
    }
    
    public String statiticResult() {
        return String.format("|%5s|%15s|%10s|%15s|", No, studentName,
                courseName, total);
    }
}
