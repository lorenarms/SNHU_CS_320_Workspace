package com.milestone.four.taskservice;

public class Task {
	
	private String _taskID;
	private String _taskName;
	private String _taskDescription;

	// constructor with error checking
	public Task(String id, String name, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_taskID = id;
		_taskName = name;
		_taskDescription = description;
	}
	
	// getters
	public String GetID() {
		return _taskID;
	}
	public String GetTaskName() {
		return _taskName;
	}
	public String GetTaskDescription() {
		return _taskDescription;
	}
	
	// setters with error checking
	public void SetTaskName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		_taskName = name;
	}
	public void SetTaskDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_taskDescription = description;
	}
}
