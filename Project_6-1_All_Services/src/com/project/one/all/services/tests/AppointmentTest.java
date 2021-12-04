package com.project.one.all.services.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.one.all.services.Appointment;

class AppointmentTest {

	@Test
	void testAppointmentNullArgument() {
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date d = c.getTime();
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment a = new Appointment(null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment a = new Appointment("123", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment a = new Appointment("123", d, null);
		});
	}
	
	@Test
	void testAppointmentInvalidArguments() {
		Date d = new Date(0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment a = new Appointment("thisidiswaytoolong", null, null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment a = new Appointment("123", d, "thisdescriptionistoolongtobevalidthisdescriptionistoolongtobevalid");
		});
		
		d.setTime(0);
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment a = new Appointment("123", d, "description");
		});
		
	}
	
	@Test
	void testAppointmentGetters() {
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date d = c.getTime();
		Appointment a = new Appointment("123", d, "description");
		Assertions.assertEquals(a.getID(), "123");
		Assertions.assertEquals(a.getApptDate(), d);
		Assertions.assertEquals(a.getDescription(), "description");
	}
	

}
