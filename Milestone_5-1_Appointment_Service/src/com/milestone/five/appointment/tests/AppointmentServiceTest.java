package com.milestone.five.appointment.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.milestone.five.appointment.service.Appointment;
import com.milestone.five.appointment.service.AppointmentService;

class AppointmentServiceTest {

	// create a valid date
	Date createADate() {
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date date = c.getTime();
		return date;
	}
	// create a date that lies before today (invalid)
	Date createBadDate() {
		Date date = new Date();
		date.setTime(1000000);
		return date;
	}
	
	// Tests for "AddAppointment" method
	@Test
	void testConstructor() {
		var apptService = new AppointmentService();
		assertTrue(apptService.GetAppointmentList().isEmpty());
		assertEquals(apptService.GetAppointmentCount(), 0);
		
		apptService.AddAppointment(createADate(), "Description");		
		apptService.PrintAppointmentList();
	}
	
	@Test
	void testAddAppointmentMethodNullDate() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(null, "Description");
		});
	}
	@Test
	void testAddAppointmentMethodNullDescription() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(createADate(), null);
		});
	}
	@Test
	void testAddAppointmentMethodBadDate() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(createBadDate(), "Description");
		});
	}
	@Test
	void testAddAppointmentMethodBadDescription() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(createADate(), "thisisadescriptionthat"
					+ "iswaaytoolongtobevalidintheprogram");
		});
	}
	
	@Test
	void testAddAppointmentMethodWithValidParameters() {
		var apptService = new AppointmentService();
		// good params
		apptService.AddAppointment(createADate(), "This is a good description");
		assertEquals(apptService.GetAppointmentCount(), 1);
		assertTrue(!apptService.GetAppointmentList().isEmpty());
		apptService.PrintAppointmentList();
		
		
	}
	
	// Tests for "RemoveAppointment" method
	@Test
	void testRemoveMethodListEmpty() {
		var apptService = new AppointmentService();
		// list is empty
		apptService.RemoveAppointment("1234567");
	}
	
	@Test
	void testRemoveMethodIDNull() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createADate(), "TO REMOVE");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.RemoveAppointment(null);
		});
	}
	@Test 
	void testRemoveMethodIDTooLong() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createADate(), "TO REMOVE");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.RemoveAppointment("1234567800090123");
					
		});
	}
	
	@Test
	void testRemoveMethodAppointmentNotInList() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createADate(), "TO REMOVE");
		apptService.RemoveAppointment("1234567");
		// can't get this one to turn green not sure why
		assertTrue(!apptService.GetAppointmentList().isEmpty());
	}
	
	@Test
	void testRemoveMethodAppointmentIsInList() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createADate(), "TO REMOVE");
		Appointment appt = apptService.GetAppointmentList().elementAt(0);
		apptService.RemoveAppointment(appt.GetID());
		assertTrue(apptService.GetAppointmentList().isEmpty());
	}
	
	// test unique id generator
	
	//@Test
	// TAKES FOREVER, DON'T USE
	//void testUniqueIDGenerator() {
	//	var apptService = new AppointmentService();
	//	for(int i = 0; i < 1000000000; i++) {
	//		String description = "Appointment # " + i;
	//		apptService.AddAppointment(createADate(), description);
	//	}
	//}

}
