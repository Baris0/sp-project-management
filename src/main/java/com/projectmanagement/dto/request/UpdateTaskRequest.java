package com.projectmanagement.dto.request;

import com.projectmanagement.model.PriorityType;
import lombok.Data;

@Data
public class UpdateTaskRequest {

    private String title;
    private String body;
    private PriorityType priorityType;
    private String assignee;
}
