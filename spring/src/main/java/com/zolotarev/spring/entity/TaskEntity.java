package com.zolotarev.spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Boolean completed;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
