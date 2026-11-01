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
public class DoctorView {

    private List<ResponseDTO> responseDTO;

    public DoctorView() {
        responseDTO = new ArrayList<>();
    }

    // Phương thức để Controller đẩy dữ liệu vào View
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    public void printDoctors() {
        // Set table header
        System.out.println((String.format("%-10s %-20s %-20s %-10s", "Code", "Name",
                "Specialization", "Availability")));
        // Build the string body of the table
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }
}
