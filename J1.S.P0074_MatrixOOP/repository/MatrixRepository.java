/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.Matrix;

/**
 *
 * @author Tuan Tran
 */
import java.util.ArrayList;
import java.util.List;
import utils.Validation;

public class MatrixRepository {
// Danh sach luu tru cac doi tuong Matrix (ma tran)
    private List<Matrix> storage;
// Constructor khoi tao danh sach luu tru ban dau la mot ArrayList rong
    public MatrixRepository() {
        this.storage = new ArrayList<>();
    }
// Phuong thuc them mot ma tran moi vao danh sach luu tru neu khac null
    public void createNewMatrix(Matrix matrix) {
        if (matrix != null) {
            storage.add(matrix);
        }
    }
// Phuong thuc lay ra ma tran theo vi tri chi so (index) hop le
    public Matrix getMatrix(int index) {
        if (index >= 0 && index < storage.size()) {
            return storage.get(index);
        }
        return null;
    }
// Phuong thuc thuc hien phep cong hai ma tran
    public void add() throws Exception {
        Matrix m1 = storage.get(0);
        Matrix m2 = storage.get(1);
        // Kiem tra dieu kien kich thuoc cho phep cong
        if (Validation.isValidAdd(m1, m2)) {
            throw new Exception("Size must be the same for addition.");
        }
        // Tao mang ket qua co cung kich thuoc
        int[][] res = new int[m1.getRows()][m1.getCols()];
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getCols(); j++) {
                res[i][j] = m1.getData()[i][j] + m2.getData()[i][j];
            }
        }
        // Tao ma tran ket qua moi va luu vao bo suu tap
        Matrix m3 = new Matrix(res);
        createNewMatrix(m3);
    }
// Phuong thuc thuc hien phep tru hai ma tran
    public void subtract() throws Exception {
        Matrix m1 = storage.get(0);
        Matrix m2 = storage.get(1);
        // Kiem tra dieu kien kich thuoc cho phep tru
        if (Validation.isValidAdd(m1, m2)) {
            throw new Exception("Size must be the same for subtraction.");
        }
        // Tao mang ket qua co cung kich thuoc
        int[][] res = new int[m1.getRows()][m1.getCols()];
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getCols(); j++) {
                res[i][j] = m1.getData()[i][j] - m2.getData()[i][j];
            }
        }
        // Tao ma tran ket qua moi va luu vao bo suu tap
        Matrix m3 = new Matrix(res);
        createNewMatrix(m3);
    }
// Phuong thuc thuc hien phep nhan hai ma tran
    public void multiply() throws Exception {
        Matrix m1 = storage.get(0);
        Matrix m2 = storage.get(1);
        // Kiem tra dieu kien cot cua ma tran 1 phai bang hang cua ma tran 2
        if (Validation.isValidMul(m1, m2)) {
            throw new Exception("Matrix 1 columns must equal Matrix 2 rows.");
        }
        // Tao mang ket qua voi so hang cua m1 va so cot cua m2
        int[][] res = new int[m1.getRows()][m2.getCols()];
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getCols(); j++) {
                for (int k = 0; k < m1.getCols(); k++) {
                    res[i][j] += m1.getData()[i][k] * m2.getData()[k][j];
                }
            }
        }
        // Tao ma tran ket qua moi va luu vao bo suu tap
        Matrix m3 = new Matrix(res);
        createNewMatrix(m3);
    }
    // Phuong thuc lay ve toan bo danh sach cac ma tran dang luu tru
    public List<Matrix> getAll() {
        return storage;
    }
    // Phuong thuc xoa tat ca du lieu co trong danh sach luu tru
    public void clear(){
        storage.clear();
    }
}
