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
	
		  // URL для серверного приложения 
      String serverUrl = "http://localhost:8080/create";
      
      // Создаем задачу
      Task task = new Task();
      task.setTitle("New");
      task.setDescription("Task");
      task.setCompleted(false);
      
      // Создаем заголовки для POST-запроса
      HttpHeaders headers = new HttpHeaders();
      
      // Создаем HTTP-сущность для отправки данных на сервер
      HttpEntity<Task> request = new HttpEntity<>(task, headers);
      
      // Отправляем POST-запрос на сервер
      ResponseEntity<Task> response = new RestTemplate().exchange(
          serverUrl,
          HttpMethod.POST,
          request,
          Task.class
      );
      
      // Получаем созданную задачу из ответа
      Task createdTask = response.getBody();
      
      // Выводим созданную задачу
      System.out.println("A new task has been created:");
      System.out.println("ID: " + createdTask.getId());
      System.out.println("Caption: " + createdTask.getTitle());
      System.out.println("Description: " + createdTask.getDescription());
      System.out.println("End: " + createdTask.isCompleted());
	}
		
	

}
