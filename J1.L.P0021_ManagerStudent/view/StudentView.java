package view;

import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;

public class StudentView {

    private List<ResponseDTO> responseDTO;

    public StudentView() {
        responseDTO = new ArrayList<>();
    }

    // Phương thức để Controller đẩy dữ liệu vào View
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    // THÊM MỚI: Phương thức dùng để in các thông báo (Lỗi, Thành công...)
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStudents() {
        // Thiet lap tieu de cho bang
        System.out.println(String.format("|%5s|%15s|%10s|%15s|", "No.", "Student Name",
                "Semester", "Course Name"));
        // Xay dung phan than cua bang
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }

    public void printReport() {
        // Thiet lap tieu de cho bang
        System.out.println(String.format("|%5s|%15s|%10s|%15s|", "No.", "Student Name", "Course", "Total of Course"));
        // Xay dung phan than cua bang
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.statiticResult());
        }
    }
}