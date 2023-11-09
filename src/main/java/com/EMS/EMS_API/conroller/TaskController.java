/*

package com.EMS.EMS_API.conroller;

import com.EMS.EMS_API.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/tasks")
    public class TaskController {

        private final TaskService taskService;

        @Autowired
        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

        @PostMapping
        public ResponseEntity<Task> createTask(@RequestBody Task task) {
            Task createdTask = taskService.createTask(task);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<Task>> getAllTask() {
            List<Task> tasks = taskService.getAllTask();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
            Task task = taskService.getTaskById(id);
            if (task != null) {
                return new ResponseEntity<>(task, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @GetMapping("/institute-term-opr")
        public ResponseEntity<List<Task>> getAllTaskByInstituteTermAndOpr(
                @RequestParam String academicTerm,
                @RequestParam Long instituteId,
                @RequestParam Long userId
        ) {
            List<Task> tasks = taskService.getAllTaskByInstituteTermAndOpr(academicTerm, instituteId, userId);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
            Task task = taskService.updateTask(id, updatedTask);
            if (task != null) {
                return new ResponseEntity<>(task, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



*/
