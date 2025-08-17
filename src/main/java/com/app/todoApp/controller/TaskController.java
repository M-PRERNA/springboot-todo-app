package com.app.todoApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todoApp.models.Task;
import com.app.todoApp.services.TaskService;

@Controller
public class TaskController {
	private final TaskService taskService;
	
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	//we want to display all tasks
	@GetMapping
	public String getTasks(Model model){
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		
		return "tasks";
	}
	
	//to add a new task
	@PostMapping
	public String createTask(@RequestParam("title") String title){
		taskService.createTask(title);
		//once the task is created, redirect to home page
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable("id") Long id){
		taskService.deleteTask(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable("id") Long id){
		System.out.println("Toggle called for task: " + id);
		taskService.toggleTask(id);
		
		return "redirect:/";
	}
}
