/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import constant.Constants;
import constant.Message;
import controller.Controller;
import dto.StudentDTO;
import java.util.Scanner;
import constant.ProgrammingLanguage;
import utils.Validation;

/**
 *
 * @author win
 */
public class Main {
    public static void main(String[] args) {
        Controller manager = new Controller();
        Scanner sc = new Scanner(System.in);
        StudentDTO dto = new StudentDTO();
        manager.setDto(dto);

        while (true) {
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            int choice = inputChoice(sc);

            switch (choice) {
                case 1: processAdd(sc, manager, dto); break;
                case 2: processFind(sc, manager, dto); break;
                case 3: processUpdateDelete(sc, manager, dto); break;
                case 4: manager.report(); break;
                case 5: System.out.println("Exiting program..."); return;
            }
        }
    }

    //Xử lý chức năng thêm sinh viên.
    private static void processAdd(Scanner sc, Controller manager, StudentDTO dto) {
        while (true) {
            try {
                String id = inputString(sc, Message.INPUT_ID, Constants.REGEX_ID);
                dto.setId(id);

                // Auto-fill tên nếu ID đã tồn tại
                String name;
                if (!manager.getService().findByID(id).isEmpty()) {
                    name = manager.getService().findByID(id).get(0).getStudentName();
                    System.out.println(Message.INPUT_NAME + name);
                } else {
                    name = inputString(sc, Message.INPUT_NAME, Constants.REGEX_NAME);
                }
                dto.setStudentName(name);
                
                dto.setSemester(inputString(sc, Message.INPUT_SEMESTER, Constants.REGEX_NAME));
                dto.setCourseName(ProgrammingLanguage.getLanguage(inputInt(sc, Message.INPUT_COURSE_CHOICE, 1, 3)));

                manager.addStudent();

                // Khi có từ 10 sinh viên trở lên thì hỏi có muốn tiếp tục thêm hay không
                if (manager.getStudentCount() >= 10) {
                    String choose = inputString(sc, Message.INPUT_YN, Constants.REGEX_YN);
                    if (choose.equalsIgnoreCase("N")) {
                        manager.displayAllStudents();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    //Xử lý chức năng tìm kiếm sinh viên theo tên và hiển thị kết quả sau khi sắp xếp.
    private static void processFind(Scanner sc, Controller manager, StudentDTO dto) {
        String searchName = inputString(sc, Message.INPUT_NAME, Constants.REGEX_NAME);
        dto.setStudentName(searchName);
        manager.findAndSort();
    }

    //Xử lý chức năng cập nhật hoặc xóa thông tin học của sinh viên.
    private static void processUpdateDelete(Scanner sc, Controller manager, StudentDTO dto) {
        String id = inputString(sc, Message.INPUT_ID, Constants.REGEX_ID);
        dto.setId(id);
        
        //// Kiểm tra sinh viên có tồn tại hay không
        if (manager.getService().findByID(id).isEmpty()) {
            System.out.println(Message.ERROR_CANNOT_FOUND);
            return;
        }

        manager.printAllRecordByID();
        
        int selection = inputInt(sc, Message.EDIT_STUDENT, 1, manager.getService().findByID(id).size());
        dto.setNo(selection); 
        
        String action = inputString(sc, Message.INPUT_UD, Constants.REGEX_UD);

        if (action.equalsIgnoreCase("u")) {
            dto.setSemester(inputString(sc, Message.EDIT_SEMESTER, Constants.REGEX_NAME));
            dto.setCourseName(ProgrammingLanguage.getLanguage(inputInt(sc, Message.INPUT_COURSE_CHOICE, 1, 3)));
            manager.update();
        } else {
            manager.delete();
        }
        manager.displayAllStudents();
    }

    // --- HELPER INPUT METHODS FOR CLEANER CODE ---

    private static int inputChoice(Scanner sc) {
        while (true) {
            try {
                System.out.print(Message.INPUT_CHOICE);
                return Validation.getInt(sc.nextLine(), 1, 5);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //Nhập chuỗi và kiểm tra regex
    private static String inputString(Scanner sc, String prompt, String regex) {
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getString(sc.nextLine(), regex);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //Nhập số nguyên và kiểm tra
    private static int inputInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getInt(sc.nextLine(), min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}