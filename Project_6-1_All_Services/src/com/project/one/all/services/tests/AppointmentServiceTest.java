package com.project.one.all.services.tests;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.one.all.services.Appointment;
import com.project.one.all.services.AppointmentService;

class AppointmentServiceTest {
	
	@Test
	void testAddAppointment() {
		var as = new AppointmentService();
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date gd = c.getTime();
				
		c.set(2020, 10, 5, 9, 15);
		Date bd = c.getTime();
		System.out.println(gd.toString());
		as.addAppointment(gd, "Description");
		Assertions.assertTrue(!as.getApptList().isEmpty());
				
	}
	
	@Test
	void testGetterAndPrint() {
		var as = new AppointmentService();
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date gd = c.getTime();
		Assertions.assertTrue(as.getAppointmentCount() == 0);
		as.addAppointment(gd, "description");
		as.printAppointmentList();
	}
	
	@Test
	void testRemoveAppointment() {
		var as = new AppointmentService();
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date gd = c.getTime();
		String id = "";
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			as.removeAppointment("123455");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			as.removeAppointment(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			as.removeAppointment("123456789010");
		});
		as.addAppointment(gd, "description");
		Assertions.assertTrue(as.getAppointmentCount() == 1);
		
		for (Appointment a : as.getApptList().values()) {
			id = a.getID(); 
		}
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			as.removeAppointment("123455");
		});
		as.removeAppointment(id);
		Assertions.assertTrue(as.getAppointmentCount() == 0);
	}
	
}
