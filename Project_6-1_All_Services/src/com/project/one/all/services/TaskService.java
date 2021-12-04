package com.project.one.all.services;

import java.util.HashMap;

public class TaskService {

	private HashMap<String, Task> _taskList = new HashMap<String, Task>();
	
	public HashMap<String, Task> getTaskList() {
		return _taskList;
	}
	
	public int getTaskCount() {
		return _taskList.size();
	}
	// print the tasks (for console testing)
	public void printTaskList() {
		for (Task t : _taskList.values()) {
			System.out.println("Task ID: " + t.getID() + " Name: " + t.getTaskName());
			System.out.println("Description: " + t.getTaskDescription());
		}
		
	}
	
	// add task with error checking
	public void addTask(String tName, String tDescription) {
		String id = UniqueIDGenerator.generateUniqueID();
		if (_taskList.size() >= UniqueIDGenerator.getMaxEntries()) {
			throw new IllegalArgumentException("Contact list is full!");
		}
		while(_taskList.containsKey(id)) {
			id = UniqueIDGenerator.generateUniqueID();
		}
		var newTask = new Task(id, tName, tDescription);
		_taskList.put(id, newTask);
		System.out.println("Task " + newTask.getTaskName() + " created and added successfully");
	}
	
	
	
	// remove task by id with error checking
	public void removeTask(String id) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (_taskList.isEmpty()) {
			throw new IllegalArgumentException("Task list is empty");
		}
		if (!_taskList.containsKey(id)) {
			throw new IllegalArgumentException("That id is not found in the task list");
		}
		else {
			_taskList.remove(id);
			System.out.println("Task removed from list");
		}
	}
	
	// update task by id with error checking
	public void updateTask(String id, Task task) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (task == null) {
			throw new IllegalArgumentException("Invalid Task");
		}
		if (_taskList.isEmpty()) {
			throw new IllegalArgumentException("Task list is empty");
		}
		if (!_taskList.containsKey(id)) {
			throw new IllegalArgumentException("Task is not found in the list");
		}
		else {
			_taskList.replace(id, task);
			System.out.println("Task updated successfully.");
		}
		
	}
		
}
