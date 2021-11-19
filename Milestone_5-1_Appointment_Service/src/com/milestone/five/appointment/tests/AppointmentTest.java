package com.milestone.five.appointment.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.milestone.five.appointment.service.Appointment;

class AppointmentTest {

	@Test
	void testApptConstructor() {
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date date = c.getTime();
		
		
		//Date date = new Date(2022, 1, 10);
		System.out.println("Date set to " + date);
		
		
		
		//id too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678901", date, "Appt Description");
		});
		//id null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, date , "Appt Description");
		});
		//description too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", date , "Thisisadescription"
					+ "thatiswaytoolongtobevalidforthisconstructor");
		});
		//description null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", date , null);
		});
		//date null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", null , "Appt Description");
		});
		//date before today
		
		date.setTime(0);
		System.out.println("Date set to " + date);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", date , "Appt Description");
		});
		
		//everything correct
		Date newDate = c.getTime();
		Appointment appt = new Appointment("1234567890", newDate, "Appt Description");
		assertTrue(appt.GetID().equals("1234567890"));
		assertTrue(appt.GetApptDate().equals(newDate));
		assertTrue(appt.GetDescription().equals("Appt Description"));
		
	}
	
	@Test
	void testSetters() {
		Calendar c = Calendar.getInstance();
		c.set(2022, 10, 5, 9, 15);
		Date date = c.getTime();
		Date newDate = c.getTime();
		Date badDate = new Date();
		badDate.setTime(10000);
		
		// make object
		Appointment appt = new Appointment("1234567890", date, "Appt Description");
		
		// set new description
		appt.SetApptDescription("This is a description");
		// null description error
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.SetApptDescription(null);
		});
		// long description error
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.SetApptDescription("Thisdescriptionistoolongtobevalidandwillthrowanerror");
		});
		// check that description is changed
		assertTrue(appt.GetDescription().equals("This is a description"));
		
		// date is before today
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.SetApptDate(badDate);
		});
		// date is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.SetApptDate(null);
		});
		
		// date is appropriate
		appt.SetApptDate(newDate);
		// check that date changed
		assertTrue(appt.GetApptDate().equals(newDate));
		
	}

}
