package com.project.one.all.services;

import java.util.Date;

public class Appointment {

	private String _apptID;
	private Date _apptDate;
	private String _apptDescription;
	
	public Appointment(String id, Date date, String description) {
		if (id == null || id.length() >  10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		_apptID = id;		
		setApptDate(date);
		setApptDescription(description);
				
	}
	
	// getters
	
	public String getID() {
		return _apptID;
	}
	public Date getApptDate() {
		return _apptDate;
	}
	public String getDescription() {
		return _apptDescription;
	}
	
	// setters, error checking included
	public void setApptDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		_apptDate = date;
	}
	public void setApptDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_apptDescription = description;
	}
}
