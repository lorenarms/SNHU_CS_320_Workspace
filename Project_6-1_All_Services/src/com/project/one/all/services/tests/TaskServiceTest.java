package com.project.one.all.services.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.one.all.services.Task;
import com.project.one.all.services.TaskService;

class TaskServiceTest {

	@Test
	void testAddTask() {
		var t = new TaskService();
		t.addTask("N", "Descrip");
		Assertions.assertTrue(t.getTaskCount() == 1);
		t.printTaskList();
		
	}
	
	@Test
	void testRemoveTask() {
		var t = new TaskService();
		String id = "";
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.removeTask(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.removeTask("123456789012");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.removeTask("123");
		});
		
		t.addTask("N", "Descrip");
		Assertions.assertTrue(t.getTaskCount() == 1);
		
		
		for (Task s : t.getTaskList().values()) {
			id = s.getID();
		}
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.removeTask("123");
		});
		
		t.removeTask(id);
		Assertions.assertTrue(t.getTaskCount() == 0);
		
		
	}
	
	@Test
	void testUpdateTask() {
		var t = new TaskService();
		String id = "";
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.updateTask(null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.updateTask("1234567891010", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.updateTask("123456789", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.updateTask("123456789", new Task("1234", "t", "Des"));
		});
		
		t.addTask("N", "Descrip");
		for (Task s : t.getTaskList().values()) {
			id = s.getID();
		}
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			t.updateTask("123456789", new Task("1234", "t", "Des"));
		});
		t.updateTask(id, new Task(id, "nam", "des"));
	}

}
