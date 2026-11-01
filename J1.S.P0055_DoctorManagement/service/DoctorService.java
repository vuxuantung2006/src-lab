/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import constant.Message;
import dto.DoctorDTO;
import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Doctor;
import repository.DoctorRepository;

/**
 *
 * @author Tuan Tran
 */
public class DoctorService {

    private DoctorRepository doctorRepo;

    public DoctorService() {
        doctorRepo = new DoctorRepository();
    }

    public boolean addWorker(DoctorDTO dto) throws Exception {
        // Delegate storage to Repository
        if (doctorRepo.getDoctor(dto.getCode()) != null) {
            throw new Exception(String.format(Message.ERROR_DUPLICATE, dto.getCode()));
        }
        return doctorRepo.addDoctor(dto) != null;
    }

    public void updateDoctor(DoctorDTO dto) throws Exception {
        Doctor existingDoctor = doctorRepo.getDoctor(dto.getCode());
        if (existingDoctor == null) {
            throw new Exception(Message.ERROR_CANNOT_FOUND);
        }
        existingDoctor.setName(dto.getName());
        existingDoctor.setSpecialization(dto.getSpecialization());
        existingDoctor.setAvailability(dto.getAvailability());
    }

    public boolean deleteDoctor(DoctorDTO dto) throws Exception {
        Doctor existingDoctor = doctorRepo.getDoctor(dto.getCode());
        if (existingDoctor == null) {
            throw new Exception(Message.ERROR_CANNOT_FOUND);
        }
        return doctorRepo.deleteDoctor(dto.getCode()) != null;
    }

    public List<ResponseDTO> searchDoctor(DoctorDTO dto) {
        List<ResponseDTO> result = new ArrayList<>();
        for (Doctor doctor : doctorRepo.getDoctorMap().values()) {
            if (doctor.getCode().toLowerCase().contains(dto.getKey().toLowerCase())
                    || doctor.getName().toLowerCase().contains(dto.getKey().toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(dto.getKey().toLowerCase())) {
                ResponseDTO res = new ResponseDTO();
                res.setCode(doctor.getCode());
                res.setName(doctor.getName());
                res.setAvailability(doctor.getAvailability());
                res.setSpecialization(doctor.getSpecialization());
                result.add(res);
            }
        }
        return result;
    }

    public List<ResponseDTO> getAllDoctors() {
        List<ResponseDTO> result = new ArrayList<>();
        for (Doctor s : doctorRepo.getAllDoctors().values()) {
            ResponseDTO res = new ResponseDTO();
            res.setCode(s.getCode());
            res.setName(s.getName());
            res.setAvailability(s.getAvailability());
            res.setSpecialization(s.getSpecialization());
            result.add(res);
        }
        return result;
    }

    public boolean isEmpty() {
        return doctorRepo.isEmpty();
    }
}
