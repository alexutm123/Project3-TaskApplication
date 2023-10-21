package com.example.springBoot.TaskApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springBoot.TaskApplication.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
