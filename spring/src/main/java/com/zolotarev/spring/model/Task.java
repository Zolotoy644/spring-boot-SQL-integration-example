package com.zolotarev.spring.model;

import com.zolotarev.spring.entity.TaskEntity;
import lombok.Data;

@Data
public class Task {
    private Long id;
    private String title;
    private Boolean completed;

    public static Task toModel(TaskEntity task) {
        Task taskModel = new Task();
        taskModel.setId(task.getId());
        taskModel.setTitle(task.getTitle());
        taskModel.setCompleted(task.getCompleted());
        return taskModel;
    }
}
