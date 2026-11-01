/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.Message;
import dto.DoctorDTO;
import dto.ResponseDTO;
import java.util.List;
import java.util.Map;
import service.DoctorService;
import view.DoctorView;

/**
 *
 * @author win
 */
public class Controller {

    private DoctorView doctorView;
    private DoctorDTO doctorDto;
    private DoctorService service;

    public Controller() {
        this.doctorView = new DoctorView();
        this.doctorDto = new DoctorDTO();
        this.service = new DoctorService();
    }

    public DoctorView getDoctorView() {
        return doctorView;
    }

    public void setDoctorDto(DoctorDTO doctorDto) {
        this.doctorDto = doctorDto;
    }

    public void addDoctor() {
        try {
            if (service.addWorker(doctorDto)) {
                System.out.println(Message.SUCCESS_ADD_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDoctor() {
        try {
            service.updateDoctor(doctorDto);
            System.out.println(Message.SUCCESS_UPDATE_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDoctor() {
        try {
            if (service.deleteDoctor(doctorDto)) {
                System.out.println(Message.SUCCESS_DELETE_MESSAGE);
            } else {
                System.out.println(Message.ERROR_CANNOT_DELETE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchDoctor() {
        List<ResponseDTO> response = service.searchDoctor(doctorDto);
        if (response.isEmpty()) {
            System.out.println(Message.ERROR_MATCH);
        } else {
            doctorView.setResponseDTO(response);
            doctorView.printDoctors();
        }
    }

    public void displayAllDoctor() {
        if (service.isEmpty()) {
            System.out.println(Message.ERROR_EMPTY);
            return;
        }
        List<ResponseDTO> response = service.getAllDoctors();
        doctorView.setResponseDTO(response);
        doctorView.printDoctors();
    }
}
