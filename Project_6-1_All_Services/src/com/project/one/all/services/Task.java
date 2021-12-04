package com.project.one.all.services;

public class Task {
	
	private String _taskID;
	private String _taskName;
	private String _taskDescription;

	// constructor with error checking
	public Task(String id, String name, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		_taskID = id;
		setTaskName(name);
		setTaskDescription(description);
	}
	
	// getters
	public String getID() {
		return _taskID;
	}
	public String getTaskName() {
		return _taskName;
	}
	public String getTaskDescription() {
		return _taskDescription;
	}
	
	// setters with error checking
	public void setTaskName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		_taskName = name;
	}
	public void setTaskDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_taskDescription = description;
	}
}
