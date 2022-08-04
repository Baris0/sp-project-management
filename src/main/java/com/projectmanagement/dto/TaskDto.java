package com.projectmanagement.dto;

import com.projectmanagement.model.PriorityType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskDto {

    private Integer code;

    private String title;

    private String body;

    private PriorityType priorityType;

    private String createdBy;

    private LocalDate createDate;

    private LocalDate updateDate;

    private UserDto assignee;
}
