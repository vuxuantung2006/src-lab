package controller;

import constant.Message;
import constant.ProgrammingLanguage;
import dto.ResponseDTO;
import dto.StudentDTO;
import service.StudentService;
import java.util.List;
import view.StudentView;

public class Controller {

    private StudentService studentService;
    private StudentView studentView;
    private StudentDTO dto;

    public Controller() {
        this.studentService = new StudentService();
        this.studentView = new StudentView();
        this.dto = new StudentDTO();
        try {
            // Tu dong tao du lieu mau khi khoi tao Controller
            generateStudent();
        } catch (Exception ex) {
            studentView.printMessage(ex.getMessage());
        }
    }

    public StudentService getService() {
        return studentService;
    }

    public StudentView getView() {
        return studentView;
    }

    public void setDto(StudentDTO dto) {
        this.dto = dto;
    }

    // Phuong thuc lay tong so luong sinh vien trong repository
    public int getStudentCount() {
        return studentService.getStudentRepo().getSize();
    }

    // Phuong thuc xu ly nghiep vu them sinh vien moi
    public void addStudent() {
        try {
            if (studentService.addStudent(dto)) {
                studentView.printMessage(Message.SUCCESS_ADD_MESSAGE);
            }
        } catch (Exception e) {
            studentView.printMessage(e.getMessage());
        }
    }

    // Phuong thuc tim kiem va hien thi tat ca ban ghi cua sinh vien theo ID
    public void printAllRecordByID() {
        List<ResponseDTO> response = studentService.findByID(dto.getId());
        if (response.isEmpty()) {
            studentView.printMessage(Message.ERROR_CANNOT_FOUND);
            return;
        }
        studentView.setResponseDTO(response);
        studentView.printStudents();
    }

    // Phuong thuc tim kiem theo ten va sap xep ket qua
    public void findAndSort() {
        List<ResponseDTO> response = studentService.findByNameAndSort(dto.getStudentName());
        if (response.isEmpty()) {
            studentView.printMessage(Message.ERROR_EMPTY); // Sửa tại đây
            return;
        }
        studentView.setResponseDTO(response);
        studentView.printStudents();
    }

    // Phuong thuc cap nhat thong tin sinh vien
    public void update() {
        try {
            if (studentService.updateStudent(dto)) {
                studentView.printMessage(Message.SUCCESS_UPDATE_MESSAGE); // Sửa tại đây
            }
        } catch (Exception e) {
            studentView.printMessage(e.getMessage()); // Sửa tại đây
        }
    }

    // Phuong thuc xoa sinh vien khoi danh sach
    public void delete() {
        try {
            if (studentService.deleteStudent(dto)) {
                studentView.printMessage(Message.SUCCESS_DELETE_MESSAGE); 
            }
        } catch (Exception e) {
            studentView.printMessage(e.getMessage());
        }
    }

    // Phuong thuc hien thi danh sach tat ca sinh vien
    public void displayAllStudents() {
        if (studentService.isEmpty()) {
            studentView.printMessage(Message.ERROR_EMPTY);
            return;
        }
        List<ResponseDTO> response = studentService.getAllStudents();
        studentView.setResponseDTO(response);
        studentView.printStudents();
    }

    // Phuong thuc tao va hien thi bao cao thong ke
    public void report() {
        if (studentService.isEmpty()) {
            studentView.printMessage(Message.ERROR_EMPTY); // Sửa tại đây
            return;
        }
        List<ResponseDTO> response = studentService.statitis();
        studentView.setResponseDTO(response);
        studentView.printReport();
    }

    // Phuong thuc noi bo dung de khoi tao san du lieu mau cho ung dung
    private void generateStudent() throws Exception {
        studentService.addStudent(new StudentDTO("s1", "Dao Van Tuan", "Fall2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s1", "Dao Van Tuan", "Summer2022", ProgrammingLanguage.DOT_NET));
        studentService.addStudent(new StudentDTO("s1", "Dao Van Tuan", "Fall2022", ProgrammingLanguage.C_CPP));
        studentService.addStudent(new StudentDTO("s2", "Doan Duy Huy", "Fall2021", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s2", "Doan Duy Huy", "Spring2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s3", "Le Thi Hoa", "Fall2022", ProgrammingLanguage.DOT_NET));
        studentService.addStudent(new StudentDTO("s4", "Le Thi Quynh", "Fall2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s5", "Le Trong Nhat", "Fall2022", ProgrammingLanguage.DOT_NET));
        studentService.addStudent(new StudentDTO("s5", "Le Trong Nhat", "Summer2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s6", "Le Van Quyen", "Fall2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s7", "Tran Nhat Anh", "Fall2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s8", "Nguyen Duc Huy", "Fall2022", ProgrammingLanguage.JAVA));
        studentService.addStudent(new StudentDTO("s9", "Ngo Thanh Ha", "Fall2022", ProgrammingLanguage.JAVA));
        
    }
}