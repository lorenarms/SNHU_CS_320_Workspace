package com.milestone.four.taskservice.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.milestone.four.taskservice.*;

class TaskServiceTest {

	@Test
	void testTaskConstructor() {
		var taskService = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			var newTask = new Task(null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			var newTask = new Task("123", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			var newTask = new Task("123", "Name", null);
		});
		// id too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			var newTask = new Task("12345678901", "Name", "Description");
		});
		// name too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			var newTask = new Task("123456789", "This name is too long of a name", "Description");
		});
		// description too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			var newTask = new Task("123456789", "name", "This description is"
					+ " too dang long to not throw an error.");
		});
		
		// test setters
		var newTask = new Task("123", "Name", "Description");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			newTask.SetTaskName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			newTask.SetTaskDescription(null);
		});
		
	}
	
	@Test
	void testGetters() {
		// test getters for count and list
		var taskService = new TaskService();
		assertTrue(taskService.GetTaskCount() == 0);
		assertTrue(taskService.GetTaskCount() != 1);
		assertTrue(taskService.GetTaskList().isEmpty());
		taskService.PrintTaskList();
	}
	
	@Test
	void testAddTaskToTaskList() {
		TaskService taskService = new TaskService();
		// null name
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			taskService.AddTask(null, "Task Description");
		});
		// null description
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			taskService.AddTask("Task Name", null);
		});
		// name too long / description too long
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			taskService.AddTask("This task name is too long for the task", "Task Description");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			taskService.AddTask("Task Name", "This task description is too long for the task and won't work"
					+ "at all and will throw an error.");
		});
		
		// test the method with valid input
		taskService.AddTask("Task Name", "Description of Task");
		assertTrue(taskService.GetTaskCount() == 1);
		assertTrue(!taskService.GetTaskList().isEmpty());
		taskService.PrintTaskList();
	}
	
	@Test
	void testRemoveTaskFromList() {
		var taskService = new TaskService();
		// empty list / no tasks to remove
		taskService.RemoveTask("1234567890");
		// null id sent
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			taskService.RemoveTask(null);
		});
		// id too long
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			taskService.RemoveTask("12345678901");
		});
		// add task to remove
		taskService.AddTask("This new Taks", "This is a task description");
		Task task = taskService.GetTaskList().elementAt(0);
		// task doesn't exist
		taskService.RemoveTask("123");
		// task does exist
		taskService.RemoveTask(task.GetID());
		assertTrue(taskService.GetTaskCount() == 0);
		assertTrue(taskService.GetTaskList().isEmpty());
	}
	
	@Test
	void testUpdateTask() {
		var taskService = new TaskService();
		
		// send bad params
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask(null, "update", 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask("1234566", null, 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask("123456", "update", -1);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask("123456789109", "update", 0);
		});
		
		
		// list is empty
		taskService.UpdateTask("123456", "update", 1);
		
		// add task
		taskService.AddTask("This new Taks", "This is a task description");
		Task task = taskService.GetTaskList().elementAt(0);
		
		// default remove
		taskService.UpdateTask(task.GetID(), "update", 0);
		
		// task not in list
		taskService.UpdateTask("123456", "Name", 1);
		
		// update task name
		taskService.UpdateTask(task.GetID(), "New Task Name", 1);
		assertEquals("New Task Name", taskService.GetTaskList().elementAt(0).GetTaskName());
		
		// update with bad name
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask(task.GetID(), "This name is way too long for the task", 1);
		});
		
		// update task description
		taskService.UpdateTask(task.GetID(), "This is a new Description", 2);
		assertEquals("This is a new Description", taskService.GetTaskList().elementAt(0).GetTaskDescription());
		
		// update with bad description
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask(task.GetID(), "This description will throw and"
					+ " error because it is just way too long for a description", 2);
		});
		
	}
	
	@Test
	void testGenerateUniqueID() {
		// no idea how to test the internal while loop in this method
		
		var taskService = new TaskService();
		String str = taskService.GenerateUniqueID();
		int t = Integer.parseInt(str);
		assertTrue(t > 0 && t < 1000000000);
	}
	

}
