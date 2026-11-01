/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;


public class TaskView {

    private List<ResponseDTO> responseDTO;

    public TaskView() {
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

    public void printTask() {
        /* Cài đặt Header cho bảng */
        System.out.println(String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer"));

        /* Duyệt qua danh sách ResponseDTO để hiển thị nội dung Body */
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }
}