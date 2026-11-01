package controller;

import dto.MatrixDTO;
import dto.ResponseDTO;
import java.util.List;
import service.MatrixService;
import view.MatrixView;

public class Controller {

    private MatrixDTO dto;
    private MatrixView view;
    private MatrixService service;

    public Controller() {
        this.dto = new MatrixDTO();
        this.view = new MatrixView();
        this.service = new MatrixService();
    }

    public void setDto(MatrixDTO dto) {
        this.dto = dto;
    }
// Thuc hien phep cong ma tran
    public void executeAddition() {
        calculate("+");
    }
// Thuc hien phep tru ma tran
    public void executeSubtraction() {
        calculate("-");
    }
// Thuc hien phep nhan ma tran
    public void executeMultiplication() {
        calculate("*");
    }
// Phuong thuc xu ly tinh toan chung dua tren toan tu duoc truyen vao
    private void calculate(String operator) {
        List<ResponseDTO> response;
        try {
            switch (operator) {
                case "+":
                    response = service.add(dto);
                    break;
                case "-":
                    response = service.subtract(dto);
                    break;
                case "*":
                    response = service.multiply(dto);
                    break;
                default:
                    throw new Exception("Invalid operator");
            }
            // Cap nhat ket qua len View va in ra man hinh
            view.setOperator(operator);
            view.setResponseDTO(response);
            view.printResult();
        } catch (Exception e) {
            // Xu ly khi co loi xay ra va hien thi thong bao loi len View
            view.setError(e.getMessage());
            view.displayErrorMessages();
        }
    }
}
