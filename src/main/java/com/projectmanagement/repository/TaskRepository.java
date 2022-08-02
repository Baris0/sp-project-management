package com.projectmanagement.repository;

import com.projectmanagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Task findTaskByCode(int code);
    List<Task> findTaskByAssignee(String mail);
}
