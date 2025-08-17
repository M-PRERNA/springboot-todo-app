package com.app.todoApp.models;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//this @Entity annotation will basically create a Task table in the todo-app db
@Entity
@Data
public class Task {
	//attributes of a Task
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private boolean completed;	
}
