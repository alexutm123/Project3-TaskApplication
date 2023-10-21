package com.example.springBoot.TaskApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.TaskApplication.Entity.Task;
import com.example.springBoot.TaskApplication.Repository.TaskRepository;

@RestController
public class TaskController {
	
	 private final  TaskRepository taskRepository;
	 
	 
	 
	@Autowired 
    public TaskController(TaskRepository taskRepository) {
	
		this.taskRepository = taskRepository;
	}

	@PostMapping("/create")
    public Task createTask(@RequestBody Task task) {

        Task savedTask = taskRepository.save(task);
        return savedTask;
    }
}
