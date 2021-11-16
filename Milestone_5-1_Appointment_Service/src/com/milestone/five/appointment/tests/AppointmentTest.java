package com.milestone.five.appointment.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.milestone.five.appointment.service.Appointment;

class AppointmentTest {

	@Test
	void testApptConstructor() {
		Date date = new Date();
		date.setTime(15680);
		
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
			new Appointment("1234567890", date , "This is a description "
					+ "that is way too long to be valid for this constructor");
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
		
		date.setTime(-16680);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678901", date , "Appt Description");
		});
		
		//everything correct
		date.setTime(20690);
		Appointment appt = new Appointment("1234567890", date, "Appt Description");
		assertTrue(appt.getID())
	}

}
