package model;

public class Matrix {
    // Khai bao mang 2 chieu de luu tru du lieu cua ma tran
    private int[][] data;

    public Matrix(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public int getRows() {
        return data.length;
    }

    public int getCols() {
        return data[0].length;
    }
}
