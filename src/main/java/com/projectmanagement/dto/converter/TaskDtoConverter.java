package com.projectmanagement.dto.converter;

import com.projectmanagement.dto.TaskDto;
import com.projectmanagement.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskDtoConverter {

    public TaskDto convert(Task task) {
        return new TaskDto(task.getCode(),
                task.getTitle(),
                task.getBody(),
                task.getPriorityType(),
                task.getCreatedBy(),
                task.getCreateDate(),
                task.getUpdateDate(),
                task.getAssignee());
    }

    public List<TaskDto> convert(List<Task> tasks) {
        return tasks.stream().map(this::convert).collect(Collectors.toList());
    }
}
