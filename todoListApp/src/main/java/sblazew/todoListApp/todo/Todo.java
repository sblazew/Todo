package sblazew.todoListApp.todo;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	public Todo(){
	}
	
	public Todo(int id, String username, String taskName, String description, LocalDate deadline) {
		super();
		this.id = id;
		this.username = username;
		this.taskName = taskName;
		this.description = description;
		this.deadline = deadline;
		}

	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@Size(min=1, message="Enter at least one character")
	private String taskName;
	private String description;
	private LocalDate deadline;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", taskName=" + taskName + ", deadline=" + deadline
				+ ", description=" + description + "]";
	}
}
