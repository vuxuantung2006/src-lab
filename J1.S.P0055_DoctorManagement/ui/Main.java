/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author win
 */
import constant.Message;
import controller.Controller;
import dto.DoctorDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        Controller control = new Controller();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Hiển thị menu
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            
            try {
                // Nhập lựa chọn
                System.out.print(Message.INPUT_CHOICE);
                int choice = Validation.getInt(sc.nextLine(), 1, 6);
                
                switch (choice) {
                    
                    // Add doctor
                    case 1:
                        DoctorDTO addDto = new DoctorDTO();
                        control.setDoctorDto(addDto);
                        
                        System.out.print(Message.INPUT_DOCTOR_CODE);
                        addDto.setCode(Validation.getString(sc.nextLine(), Message.REGEX_CODE));
                        
                        System.out.print(Message.INPUT_NAME);
                        addDto.setName(Validation.getString(sc.nextLine(), Message.REGEX_NAME));
                        
                        System.out.print(Message.INPUT_SPECIALIZATION);
                        addDto.setSpecialization(Validation.getString(sc.nextLine(), Message.REGEX_NAME));
                        
                        System.out.print(Message.INPUT_AVAILABILITY);
                        addDto.setAvailability(Validation.getInt(sc.nextLine(), 1, Integer.MAX_VALUE));
                        
                        control.addDoctor();
                        break;
                        
                    // Update doctor
                    case 2:
                        DoctorDTO updateDto = new DoctorDTO();
                        control.setDoctorDto(updateDto);
                        
                        System.out.print(Message.INPUT_DOCTOR_CODE);
                        updateDto.setCode(Validation.getString(sc.nextLine(), Message.REGEX_CODE));
                        
                        System.out.print(Message.INPUT_NAME);
                        updateDto.setName(Validation.getString(sc.nextLine(), Message.REGEX_NAME));
                        
                        System.out.print(Message.INPUT_SPECIALIZATION);
                        updateDto.setSpecialization(Validation.getString(sc.nextLine(), Message.REGEX_NAME));
                        
                        System.out.print(Message.INPUT_AVAILABILITY);
                        updateDto.setAvailability(Validation.getInt(sc.nextLine(), 1, Integer.MAX_VALUE));
                        
                        control.updateDoctor();
                        break;
                        
                    // Delete doctor
                    case 3:
                        DoctorDTO deleteDto = new DoctorDTO();
                        control.setDoctorDto(deleteDto);
                        
                        System.out.print(Message.INPUT_DOCTOR_CODE);
                        deleteDto.setCode(Validation.getString(sc.nextLine(), Message.REGEX_CODE));
                        
                        control.deleteDoctor();
                        break;
                        
                    // Search doctor
                    case 4:
                        DoctorDTO searchDto = new DoctorDTO();
                        control.setDoctorDto(searchDto);
                        
                        System.out.print(Message.INPUT_KEY);
                        searchDto.setKey(Validation.getString(sc.nextLine(), Message.REGEX_NAME));
                        
                        control.searchDoctor();
                        break;
                        
                    // Display all
                    case 5:
                        control.displayAllDoctor();
                        break;
                        
                    // Exit program
                    case 6:
                        System.out.println("Exiting program...");
                        System.exit(0);
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}