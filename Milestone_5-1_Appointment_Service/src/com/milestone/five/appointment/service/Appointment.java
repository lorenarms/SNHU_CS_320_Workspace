package com.milestone.five.appointment.service;

import java.util.Date;

//The appointment object shall have a required unique appointment 
//ID string that cannot be longer than 10 characters. The appointment 
//ID shall not be null and shall not be updatable.

//The appointment object shall have a required appointment Date field. 
//The appointment Date field cannot be in the past. The appointment 
//Date field shall not be null.

//The appointment object shall have a required description String field 
//that cannot be longer than 50 characters. The description field shall 
//not be null.


public class Appointment {

	private String _apptID;
	private Date _apptDate;
	private String _apptDescription;
	
	public Appointment(String id, Date date, String description) {
		if (id == null || id.length() >  10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointmene Date");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		_apptID = id;
		_apptDate = date;
		_apptDescription = description;
	}
	
	// getters
	
	public String GetID() {
		return _apptID;
	}
	public Date GetApptDate() {
		return _apptDate;
	}
	public String GetDescription() {
		return _apptDescription;
	}
	
	// setters, error checking included
	public void SetApptDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointmene Date");
		}
		_apptDate = date;
	}
	public void SetApptDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_apptDescription = description;
	}
}
