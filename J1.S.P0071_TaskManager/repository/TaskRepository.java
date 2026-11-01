/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dto.ResponseDTO;
import dto.TaskDTO;
import java.util.ArrayList;
import java.util.List;
import model.Task;

public class TaskRepository {

    private List<Task> taskList;
    private int lastId;

    public TaskRepository() {
        this.taskList = new ArrayList<>();
        this.lastId = 0;
    }

    public int addTask(TaskDTO dto) {
        Task task = new Task(dto.getTaskType(), dto.getRequirementName(),
                dto.getDate(), dto.getPlanFrom(), dto.getPlanTo(), dto.getAssign(), dto.getReviewer());
        task.setId(++lastId);
        if (taskList.add(task)) {
            return task.getId();
        } else {
            return -1;
        }
    }

    public boolean deleteTask(int id) {
        return taskList.removeIf(task -> task.getId() == id);
    }

    public List<ResponseDTO> getAllTasks() {
        // Tạo danh sách kết quả mới kiểu ResponseDTO
        List<ResponseDTO> result = new ArrayList<>();

        // Duyệt qua danh sách Task hiện có
        for (Task task : taskList) {
            ResponseDTO res = new ResponseDTO();
            // Gán dữ liệu đã format vào Body của DTO
            res.setId(task.getId());
            res.setRequirementName(task.getRequirementName());
            res.setTaskType(task.getTaskType());
            res.setDate(task.getDate());
            res.setTime(task.getPlanTo() - task.getPlanFrom());
            res.setAssign(task.getAssign());
            res.setReviewer(task.getReviewer());
            result.add(res);
        }
        return result;
    }

    public Task findById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}
