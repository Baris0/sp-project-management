package com.projectmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Task {

    @Id
    private String id;

    private Integer code;

    private String title;

    private String body;

    private PriorityType priorityType;

    private String createdBy;

    private LocalDate createDate;

    private LocalDate updateDate;

    private User assignee;

}
