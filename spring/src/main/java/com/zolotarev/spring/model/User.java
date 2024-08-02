package com.zolotarev.spring.model;

import com.zolotarev.spring.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
    private Long id;
    private String username;
    private List<Task> tasks;

    public static User toModel(UserEntity user) {
        User model = new User();
        model.id = user.getId();
        model.username = user.getUsername();
        model.tasks = user.getTasks().stream().map(Task::toModel).collect(Collectors.toList());
        return model;
    }
}
