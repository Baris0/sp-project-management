package com.projectmanagement.service;

import com.projectmanagement.dto.TaskDto;
import com.projectmanagement.dto.UserDto;
import com.projectmanagement.dto.converter.TaskDtoConverter;
import com.projectmanagement.dto.request.TaskCreateRequest;
import com.projectmanagement.dto.request.UserCreateRequest;
import com.projectmanagement.model.Task;
import com.projectmanagement.model.User;
import com.projectmanagement.repository.TaskRepository;
import com.projectmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskDtoConverter taskDtoConverter;

    private final UserService userService;

    private final UserRepository userRepository;

    public TaskDto save(TaskCreateRequest request) {
        Task task = new Task();
        task.setId(UUID.randomUUID().toString());
        task.setCode(RandomGenerator.getDefault().nextInt(1, 1000));
        task.setCreateDate(LocalDate.now());
        task.setBody(request.getBody());
        task.setTitle(request.getTitle());
        task.setPriorityType(request.getPriorityType());
        task.setCreatedBy(request.getCreatedBy());
        task.setAssignee(request.getAssignee());

        User user = userService.getUser(request.getAssignee());
        user.setTasks(get(request.getAssignee()));


        taskRepository.save(task);
        userRepository.save(user);

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

    public List<TaskDto> getByAssignee(String mail) {
        return taskDtoConverter.convert(taskRepository.findTaskByAssignee(mail));
    }

    private List<Task> get(String mail) {
        return taskRepository.findTaskByAssignee(mail);
    }

}
