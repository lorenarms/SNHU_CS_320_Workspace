package com.project.one.all.services.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.one.all.services.Task;

class TaskTest {

	@Test
	void testTaskNullArgument() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task(null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", "T", null);
		});
	}
	
	@Test
	void testTaskInvalidArgument() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789toolong", "T", "Descrip");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", "Thisnameistoolonghihi", "Descrip");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", "T", "DescripThisnameistoolongDescripThisnameistoolonghhh");
		});
	}
	
	@Test
	void testTaskGetters() {
		Task t = new Task("123", "T", "D");
		Assertions.assertEquals(t.getID(), "123");
		Assertions.assertEquals(t.getTaskDescription(), "D");
		Assertions.assertEquals(t.getTaskName(), "T");
	}

}
