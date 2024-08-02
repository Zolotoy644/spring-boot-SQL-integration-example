package com.zolotarev.spring.repository;

import com.zolotarev.spring.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
