/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import constant.Message;
import controller.Controller;
import dto.MatrixDTO;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author win
 */
public class Main {

    public static void main(String[] args) {
        Controller control = new Controller();
        MatrixDTO dto = new MatrixDTO();
        control.setDto(dto);
        while (true) {
            // Hien thi menu ung dung lay tu Controller/Message
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
                // Nhap va kiem tra tinh hop le cua lua chon menu (tu 1 den 4)
            int choice = getSafeInt(Message.PROMPT_CHOICE, 1, 4);

            if (choice == 4) {
                break;
            }

                // Thu thap du lieu hai ma tran
            int[][] m1 = inputSingleMatrix(1);
            int[][] m2 = inputSingleMatrix(2);

            //Dong goi du lieu vao doi tuong DTO
            dto.setMatrix1(m1);
            dto.setMatrix2(m2);

                // Cau truc re nhanh
            switch (choice) {
                case 1:
                    control.executeAddition();
                    break;
                case 2:
                    control.executeSubtraction();
                    break;
                case 3:
                    control.executeMultiplication();
                    break;
            }
        }
    }


    private static int getSafeInt(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        // Vong lap nhap lien tuc cho den khi nhan duoc gia tri so nguyen hop le
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                // Goi logic kiem tra hop le tu Validation
                return Validation.getInt(input, min, max);
            } catch (Exception e) {
                // In ra thong bao loi cu the tu lop Validation
                System.out.println(e.getMessage());
            }
        }
    }


    private static int[][] inputSingleMatrix(int matrixNumber) {
        // Nhap so hang va so cot cho ma tran voi gioi han tu 1 den 10
        int rows = getSafeInt(String.format(Message.PROMPT_ROW, matrixNumber), 1, 10);
        int cols = getSafeInt(String.format(Message.PROMPT_COL, matrixNumber), 1, 10);

        int[][] data = new int[rows][cols];
        System.out.println(String.format(Message.PROMPT_ELEMENTS, matrixNumber));

        // Vong lap nhap gia tri cho tung phan tu trong ma tran
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = getSafeInt(
                        String.format(Message.PROMPT_MATRIX_CELL, matrixNumber, i + 1, j + 1),
                        Integer.MIN_VALUE, Integer.MAX_VALUE
                );
            }
        }
        return data;
    }
}
