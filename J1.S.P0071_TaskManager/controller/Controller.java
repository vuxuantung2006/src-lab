/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.Message;
import dto.ResponseDTO;
import dto.TaskDTO;
import java.util.ArrayList;
import java.util.List;
import repository.TaskRepository;
import view.TaskView;


public class Controller {

    private TaskRepository taskRepository; // Gọi trực tiếp Repository
    private TaskDTO taskDto;
    private TaskView taskView;

    public Controller() {
        this.taskRepository = new TaskRepository();
        this.taskDto = new TaskDTO();
        this.taskView = new TaskView();
    }

    public TaskView getView() {
        return taskView;
    }

    public TaskDTO getDto() {
        return taskDto;
    }

    public void addTask() {
        // Thực hiện thêm và kiểm tra kết quả trả về
        int generatedId = taskRepository.addTask(taskDto);
        if (generatedId > 0) {
            taskView.printMessage(Message.SUCCESS_ADD_MESSAGE); 
        } else {
            taskView.printMessage(Message.ERROR_CANNOT_ADD); 
        }
    }

    public void deleteTask() {
        // Logic kiểm tra ID tồn tại trước khi xóa (Thay cho Service)
        if (taskRepository.findById(taskDto.getId()) == null) {
            taskView.printMessage(Message.ERROR_CANNOT_FOUND); 
            return;
        }

        if (taskRepository.deleteTask(taskDto.getId())) {
            taskView.printMessage(Message.SUCCESS_DELETE_MESSAGE); 
        }
    }

    public void showTasks() {
        try {
            // Kiểm tra danh sách trống trước khi lấy dữ liệu
            if (taskRepository.isEmpty()) {
                throw new Exception(Message.ERROR_EMPTY);
            }
            // Yêu cầu View hiển thị
            List<ResponseDTO> response = taskRepository.getAllTasks();
            taskView.setResponseDTO(response);
            taskView.printTask();
        } catch (Exception ex) {
            taskView.printMessage(ex.getMessage()); 
        }
    }

    // Getters và Setters cho DTO
    public void setDto(TaskDTO dto) {
        this.taskDto = dto;
    }
}