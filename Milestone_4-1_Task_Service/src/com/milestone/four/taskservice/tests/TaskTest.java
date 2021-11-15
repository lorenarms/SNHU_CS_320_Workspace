package com.milestone.four.taskservice.tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.milestone.four.taskservice.Task;

class TaskTest {

	@Test 
	void testTaskConstructor() {
		// id too long
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890A", "TaskName", "TaskDescription");
		});
		// name too long
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", "TaskNameABCDEFGHIJKLM", "TaskDescription");
		});
		// description too long
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", "TaskName", "TaskDescriptionTaskDescriptionTaskDescription"
					+ "TaskDescriptionTaskDescriptionTaskDescriptionTaskDescription");
		});
		// null id
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task(null, "TaskName", "TaskDescription");
		});
		// name null
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", null, "TaskDescription");
		});
		// description null
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", "TaskName", null);
		});
		
	}
	
	@Test
	void testTaskConstructorAndGetters() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		assertTrue(task.GetID().equals("1234567890"));
		assertTrue(task.GetTaskName().equals("Task Name"));
		assertTrue(task.GetTaskDescription().equals("Task Description"));
	}
	
	@Test
	void testTaskSetters() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskName("This Name is Waaaaay Too Long");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskDescription(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskDescription("This is a task description that's really"
					+ "way too long to be valid so it throws an error");
		});
		task.SetTaskName("New Name");
		task.SetTaskDescription("New Description");
		assertTrue(task.GetTaskName().equals("New Name"));
		assertTrue(task.GetTaskDescription().equals("New Description"));
	}

}
