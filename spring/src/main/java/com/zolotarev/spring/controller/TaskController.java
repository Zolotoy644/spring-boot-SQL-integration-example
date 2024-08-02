package com.zolotarev.spring.controller;

import com.zolotarev.spring.entity.TaskEntity;
import com.zolotarev.spring.model.Task;
import com.zolotarev.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody TaskEntity task,
                           @RequestParam Long userId) {
        try {
            return ResponseEntity.ok().body(taskService.createTask(task, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating task");
        }
    }

    @PutMapping
    public ResponseEntity completeTask(@RequestBody Long Id) {
        try {
            return ResponseEntity.ok().body(taskService.completeTask(Id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
