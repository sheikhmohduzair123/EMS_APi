package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.Marks;
import com.EMS.EMS_API.entity.Task;
import com.EMS.EMS_API.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public List<Task> getAllTaskByInstituteTermAndOpr(String academicTerm, Long instituteId, Long userId) {

        return taskRepo.findByAcademicTermAndInstituteIdAndUserId(academicTerm, instituteId, userId);
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = taskRepo.findById(id).orElse(null);
        if (existingTask != null) {
           List<Marks> marks= updatedTask.getMarks();
            existingTask.setMarks(updatedTask.getMarks());
            // Update other properties as needed
            return taskRepo.save(existingTask);
        }
        return null; // Return null if the task with the given ID is not found
    }

    public void deleteTask(Long id) {
        // Delete a task by ID
        taskRepo.deleteById(id);
    }
}

