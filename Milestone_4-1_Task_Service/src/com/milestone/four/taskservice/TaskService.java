package com.milestone.four.taskservice;

import java.util.Random;
import java.util.Vector;


public class TaskService {

	private Vector<Task> _taskList = new Vector<Task>();
	private int _taskCount = 0;
		
	// list of tasks
	public Vector<Task> GetTaskList() {
		return _taskList;
	}
	// count of tasks
	public int GetTaskCount() {
		return _taskCount;
	}
	// print the tasks (for console testing)
	public void PrintTaskList() {
		for (Task t : _taskList) {
			System.out.println("Task ID: " + t.GetID() + " Name: " + t.GetTaskName());
			System.out.println("Description: " + t.GetTaskDescription() + "\n");
		}
	}
	
	// add task with error checking
	public void AddTask(String tName, String tDescription) {
		if (tName == null || tName.length() > 20) {
			throw new IllegalArgumentException("Invalid name length");
		}
		if (tDescription == null || tDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description length");
		}
		String newID = GenerateUniqueID();
		var newTask = new Task(newID, tName, tDescription);
		_taskList.add(newTask);
		_taskCount = GetTaskCount() + 1;
		System.out.println("Task " + newTask.GetTaskName() + " created and added successfully");
	}
	
	// internal remove and add methods
	private void AddTask(Task task) {
		_taskList.add(task);
		_taskCount = GetTaskCount() + 1;
	}
	private void RemoveTask(Task task) {
		_taskList.remove(task);
		_taskCount = GetTaskCount() - 1;
	}
	
	// remove task by id with error checking
	public void RemoveTask(String id) {
		if (_taskList.isEmpty()) {
			System.out.print("There are no tasks to remove");
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		//search id's in list and store index of matching task
		int index = -1;
		for (Task t : _taskList) {
			if (t.GetID() == id) {
				index = _taskList.indexOf(t);
			}
		}
		// task wasn't found / doesn't exist
		if (index == -1) {
			// output to console
			System.out.println("Task not found");
			return;
		}
		else {
			// remove the task using internal method
			_taskList.remove(index);
			_taskCount = GetTaskCount() - 1;
			System.out.println("Task removed from list");
		}
	}
	
	// update task by id with error checking
	public void UpdateTask(String id, String update, int selection) {
		if (id == null || id.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Bad Request");
		}
		if (_taskList.isEmpty()) {
			System.out.println("No tasks in list");
			return;
		}
		// find matching task in list
		int index = -1;
		for (Task t : _taskList) {
			if (t.GetID() == id) {
				index = _taskList.indexOf(t);
			}
		}
		// task not found / doesn't exist
		if (index == -1) {
			System.out.println("Task not found, check ID");
			return;
		}
		// create new temp task
		Task updateTask = _taskList.get(index);
		// conditional for what needs to be updated
		// 1 = name
		// 2 = description
		switch (selection) {
		case 1:{
			updateTask.SetTaskName(update);
			break;
		}
		case 2:{
			updateTask.SetTaskDescription(update);
			break;
		}
		// any other number selection
		default:{
			System.out.println("Task not updated, invalid change requested.");
			break;
		}
		}
		// remove task
		RemoveTask(_taskList.elementAt(index));
		// add updated task
		AddTask(updateTask);
		
	}
	
	// generate a unique id number for created task
	public String GenerateUniqueID() {
		// randomize number with 9 - 10 digits
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		// temporary vector of strings for ids
		Vector<String> idList = new Vector<String>();
		// fill vector with existing ids
		for (Task t : _taskList) {
			idList.add(t.GetID());
		}
		// compare newly created id to list of existing
		while (idList.contains(uniqueID) || uniqueID.length() > 10) {
			// if match was found, create a new id
			newID = rand.nextInt(1000000000);
			uniqueID = Integer.toString(newID);
		}
		// remove temp vector
		idList = null;
		// return created id
		return uniqueID;
	}




	
}
