package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.domain.Task;
import cz.upce.cv01.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TaskQLController {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskQLController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @SchemaMapping(typeName = "AppUser")
    public List<Task> tasks (@Argument AppUser appUser) {
        return taskRepository.findByAuthor(appUser);
    }
}
