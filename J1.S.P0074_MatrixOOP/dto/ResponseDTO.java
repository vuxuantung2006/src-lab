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
public class ResponseDTO {
// Khai bao mang 2 chieu de luu tru du lieu ket qua sau khi tinh toan
    private int[][] data;

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String formatMatrix() {
        StringBuilder sb = new StringBuilder();
        // Duyet qua tung hang trong mang 2 chieu
        for (int[] row : data) {
            // Duyet qua tung phan tu (cell) trong hang
            for (int cell : row) {
                sb.append("[").append(cell).append("]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
