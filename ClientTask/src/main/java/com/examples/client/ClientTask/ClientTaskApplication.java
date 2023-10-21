package com.examples.client.ClientTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.springBoot.TaskApplication.TaskApplication;
import com.example.springBoot.TaskApplication.Entity.Task;

@SpringBootApplication
public class ClientTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientTaskApplication.class, args);
	
		// URL for server application
      String serverUrl = "http://localhost:8080/create";
      
      
      Task task = new Task();
      task.setTitle("New");
      task.setDescription("Task");
      task.setCompleted(false);
      
   // Create headers for POST request
      HttpHeaders headers = new HttpHeaders();
      
   // Create an HTTP entity to send data to the server
      HttpEntity<Task> request = new HttpEntity<>(task, headers);
      
   // Send POST request to the server
      ResponseEntity<Task> response = new RestTemplate().exchange(
          serverUrl,
          HttpMethod.POST,
          request,
          Task.class
      );
      
   // Get the created task from the response
      Task createdTask = response.getBody();
      
   // Output the created task
      System.out.println("A new task has been created:");
      System.out.println("ID: " + createdTask.getId());
      System.out.println("Caption: " + createdTask.getTitle());
      System.out.println("Description: " + createdTask.getDescription());
      System.out.println("End: " + createdTask.isCompleted());
	}
		
	

}
