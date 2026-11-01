/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuan Tran
 */
public class MatrixView {

    private List<ResponseDTO> responseDTO;
    private String operator;
    private String error;
    private String mess;

    public MatrixView() {
        responseDTO = new ArrayList<>();
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setError(String error) {
        this.error = error;
    }

    // Phương thức để Controller đẩy dữ liệu vào View
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    public void printResult() {
        /* Cài đặt Header cho bảng */
        System.out.println("-------- Result --------");
        /* Duyệt qua danh sách ResponseDTO để hiển thị nội dung Body */
        System.out.print(responseDTO.get(0).formatMatrix());
        System.out.println(operator);
        System.out.print(responseDTO.get(1).formatMatrix());
        System.out.println("=");
        System.out.print(responseDTO.get(2).formatMatrix());
    }

    public void displayErrorMessages() {
        if (responseDTO != null) {
            System.out.println("ERROR: " + error);
        }
    }

    public void displayMessages() {
        if (responseDTO != null) {
            System.out.println(mess);
        }
    }
}
