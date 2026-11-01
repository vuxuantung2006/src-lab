/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import constant.Message;
import dto.ResponseDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Collections;
import model.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Enrollment;
import repository.StudentRepository;

/**
 *
 * @author win
 */
public class StudentService {

    private StudentRepository studentRepo;

    public StudentService() {
        studentRepo = new StudentRepository();
    }

    public StudentRepository getStudentRepo() {
        return studentRepo;
    }

    public boolean isEmpty() {
        return studentRepo.isEmpty();
    }

    //Thêm sinh viên mới hoặc thêm khóa học cho sinh viên đã tồn tại.
    public boolean addStudent(StudentDTO dto) throws Exception {
        Student s = studentRepo.findById(dto.getId());

        // 1. Chỉ quản lý việc tạo/kiểm tra sinh viên
        if (s == null) {
            s = new Student(dto.getId(), dto.getStudentName());
            studentRepo.addStudent(s);
        } else if (!s.getStudentName().equalsIgnoreCase(dto.getStudentName())) {
            throw new Exception(Message.ERROR_DUPLICATE_ID + s.getStudentName());
        }

        // 2. Thêm trực tiếp lượt học
        s.addEnrollment(new Enrollment(dto.getSemester(), dto.getCourseName()));
        return true;
    }

    //Tìm tất cả bản ghi học tập của sinh viên theo ID.
    public List<ResponseDTO> findByID(String id) {
        Student student = studentRepo.findById(id);

        if (student == null) {
            return new ArrayList<>();
        }

        return convertToResponse(student, 1);
    }

    //Tìm sinh viên theo tên và sắp xếp kết quả theo tên.
    public List<ResponseDTO> findByNameAndSort(String name) {
        List<Student> students = studentRepo.findByName(name);
        List<ResponseDTO> result = new ArrayList<>();

        int no = 1;

        for (Student student : students) {

            List<ResponseDTO> temp = convertToResponse(student, no);

            result.addAll(temp);

            no += temp.size();
        }

        Collections.sort(result);

        return result;
    }

    //Lấy toàn bộ danh sách sinh viên cùng các khóa học đã đăng ký.
    public List<ResponseDTO> getAllStudents() {
        List<ResponseDTO> result = new ArrayList<>();

        int no = 1;

        for (Student student : studentRepo.getAllStudents()) {

            List<ResponseDTO> temp = convertToResponse(student, no);

            result.addAll(temp);

            no += temp.size();
        }

        return result;
    }

    //Cập nhật thông tin học phần của sinh viên.
    public boolean updateStudent(StudentDTO dto) throws Exception {
        Student s = studentRepo.findById(dto.getId());

        // Kiểm tra sinh viên và vị trí bản ghi có hợp lệ không
        if (s == null || dto.getNo() < 1 || dto.getNo() > s.getEnrollments().size()) {
            throw new Exception(Message.ERROR_CANNOT_FOUND);
        }

        // Kiểm tra trùng lặp gọi trược tiếp hàm isDuplicated
        if (s.isDuplicated(dto.getSemester(),
                dto.getCourseName(),
                dto.getNo() - 1)) {

            throw new Exception(Message.ERROR_DUPLICATE);
        }

        // Cập nhật thông tin
        Enrollment e = s.getEnrollments().get(dto.getNo() - 1);
        e.setSemester(dto.getSemester());
        e.setCourse(dto.getCourseName());

        return true;
    }

    //Xóa một bản ghi học tập của sinh viên.
    public boolean deleteStudent(StudentDTO dto) throws Exception {
        Student s = studentRepo.findById(dto.getId());
        if (s == null || dto.getNo() < 1 || dto.getNo() > s.getEnrollments().size()) {
            throw new Exception(Message.ERROR_CANNOT_FOUND);
        }
        s.getEnrollments().remove(dto.getNo() - 1);

        // Nếu SV đã bị xóa hết môn học, có thể xóa luôn SV đó khỏi DB
        if (s.getEnrollments().isEmpty()) {
            studentRepo.getAllStudents().remove(s);
        }
        return true;
    }

    //Thống kê số lần đăng ký của từng sinh viên theo từng môn học.
    public List<ResponseDTO> statitis() {
        List<ResponseDTO> result = new ArrayList<>();
        Map<String, Integer> reports = new HashMap<>();

        for (Student s : studentRepo.getAllStudents()) {
            for (Enrollment e : s.getEnrollments()) {
                String key = s.getStudentName() + "#" + e.getCourse().valueLanguage();
                reports.put(key, reports.getOrDefault(key, 0) + 1);
            }
        }

        int no = 0;
        for (Map.Entry<String, Integer> entry : reports.entrySet()) {
            String[] parts = entry.getKey().split("#");
            ResponseDTO res = new ResponseDTO();
            res.setNo(++no);
            res.setStudentName(parts[0]);
            res.setCourseName(parts[1]);
            res.setTotal(entry.getValue());
            result.add(res);
        }
        return result;
    }

    //Hàm code thêm tránh lặp lại code chuyển dữ liệu Student sang danh sách ResponseDTO để hiển thị.
    private List<ResponseDTO> convertToResponse(Student student, int startNo) {
        List<ResponseDTO> result = new ArrayList<>();

        int no = startNo;

        for (Enrollment e : student.getEnrollments()) {
            ResponseDTO res = new ResponseDTO();

            res.setNo(no++);
            res.setId(student.getId());
            res.setStudentName(student.getStudentName());
            res.setSemester(e.getSemester());
            res.setCourseName(e.getCourse().valueLanguage());

            result.add(res);
        }

        return result;
    }
}
