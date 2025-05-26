package com.myproject.taskmanager.controller;

import com.myproject.taskmanager.dto.TaskDto;
import com.myproject.taskmanager.service.TaskService;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@ResponseBody
@RequestMapping("/tasks")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService taskService) {
        this.service = taskService;
    }


    @GetMapping
    public ResponseEntity<List<TaskDto>> GetAllTask() {
        List<TaskDto> tasks = service.getAllTask();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TaskDto> saveOrUpdateTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(service.saveOrUpdateTask(taskDto));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> ToggleTask(@PathVariable Long id) {
        return ResponseEntity.ok(service.toggleTask(id));

    }
}