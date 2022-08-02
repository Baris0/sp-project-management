package com.projectmanagement.dto.request;

import com.projectmanagement.model.PriorityType;
import lombok.Data;

@Data
public class TaskCreateRequest {

    private String title;

    private String body;

    private PriorityType priorityType;

    private String createdBy;

    private String assignee;

}
