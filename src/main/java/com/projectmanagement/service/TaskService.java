package com.projectmanagement.service;

import com.projectmanagement.dto.TaskDto;
import com.projectmanagement.dto.converter.TaskDtoConverter;
import com.projectmanagement.dto.request.TaskCreateRequest;
import com.projectmanagement.model.Task;
import com.projectmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskDtoConverter taskDtoConverter;

    private final UserService userService;

    public TaskDto save(TaskCreateRequest request) {
        Task task = new Task();
        task.setId(UUID.randomUUID().toString());
        task.setCode(RandomUtils.nextInt(1, 1000));
        task.setCreateDate(LocalDate.now());
        task.setBody(request.getBody());
        task.setTitle(request.getTitle());
        task.setPriorityType(request.getPriorityType());
        task.setCreatedBy(request.getCreatedBy());
        task.setAssignee(userService.getByUserName(request.getAssignee()));

        taskRepository.save(task);

        return taskDtoConverter.convert(task);
    }

    public List<TaskDto> getAll() {
        return taskDtoConverter.convert(taskRepository.findAll());
    }

    public void delete(int code) {
        Task task = taskRepository.findTaskByCode(code);
        taskRepository.deleteById(task.getId());
    }

    public TaskDto getByCode(int code) {
        return taskDtoConverter.convert(taskRepository.findTaskByCode(code));
    }

}
