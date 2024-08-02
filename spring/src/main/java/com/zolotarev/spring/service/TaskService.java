package com.zolotarev.spring.service;

import com.zolotarev.spring.entity.TaskEntity;
import com.zolotarev.spring.entity.UserEntity;
import com.zolotarev.spring.model.Task;
import com.zolotarev.spring.repository.TaskRepository;
import com.zolotarev.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    public Task createTask(TaskEntity taskEntity, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        taskEntity.setUser(user);
        return Task.toModel(taskRepository.save(taskEntity));
    }

    public Task completeTask(Long Id) {
        TaskEntity taskEntity = taskRepository.findById(Id).get();
        taskEntity.setCompleted(!taskEntity.getCompleted());
        return Task.toModel(taskRepository.save(taskEntity));
    }
}
