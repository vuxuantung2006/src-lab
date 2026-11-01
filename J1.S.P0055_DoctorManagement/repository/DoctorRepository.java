/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dto.DoctorDTO;
import java.util.HashMap;
import java.util.Map;
import model.Doctor;

/**
 *
 * @author Tuan Tran
 */
public class DoctorRepository {

    private Map<String, Doctor> doctorMap;

    public DoctorRepository() {
        this.doctorMap = new HashMap<>();
    }

    public Map<String, Doctor> getDoctorMap() {
        return doctorMap;
    }

    public Doctor getDoctor(String id) {
        return doctorMap.get(id);
    }

    public Doctor addDoctor(DoctorDTO dto) {
        Doctor doctor = new Doctor(dto.getCode(), dto.getName(), dto.getSpecialization(), dto.getAvailability());
        return doctorMap.put(doctor.getCode(), doctor);
    }

    public boolean isEmpty() {
        return doctorMap.isEmpty();
    }

    public Map<String, Doctor> getAllDoctors() {
        return new HashMap<>(doctorMap);
    }

    public Doctor deleteDoctor(String id) {
        return doctorMap.remove(id);
    }
}
