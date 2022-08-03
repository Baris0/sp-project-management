package com.projectmanagement.controller;

import com.projectmanagement.dto.TaskDto;
import com.projectmanagement.dto.request.TaskCreateRequest;
import com.projectmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> save(@RequestBody TaskCreateRequest request) {
        return new ResponseEntity<>(taskService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{taskCode}")
    public ResponseEntity<?> delete(@PathVariable("taskCode") int taskCode) {
        taskService.delete(taskCode);
        return new ResponseEntity<>(taskCode, HttpStatus.OK);
    }

    @GetMapping("/{taskCode}")
    public ResponseEntity<TaskDto> getByCode(@PathVariable("taskCode") int code) {
        return new ResponseEntity<>(taskService.getByCode(code), HttpStatus.OK);
    }
}
