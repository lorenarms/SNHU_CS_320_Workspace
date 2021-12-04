package com.project.one.all.services;

import java.util.Date;
import java.util.HashMap;

public class AppointmentService {
	
	private HashMap<String, Appointment> _apptList = new HashMap<String, Appointment>();

	// getters
	public int getAppointmentCount() {
		return _apptList.size();
	}
	
	public HashMap<String, Appointment> getApptList(){
		return _apptList;
	}
	
		
	// print appointments (for console debugging)
	public void printAppointmentList() {
		for (Appointment a : _apptList.values()) {
			System.out.println("Appointment ID: " + a.getID() +
					"\nAppointment Date: " + a.getApptDate().toString() +
					"\nAppointment Description: " + a.getDescription());
		}
	}
	
	// add appointments
	public void addAppointment(Date date, String description) {
		String id = UniqueIDGenerator.generateUniqueID();
		if (_apptList.size() >= UniqueIDGenerator.getMaxEntries()) {
			throw new IllegalArgumentException("Contact list is full!");
		}
		while(_apptList.containsKey(id)) {
			id = UniqueIDGenerator.generateUniqueID();
		}
		var newAppt = new Appointment(id, date, description);
		_apptList.put(id, newAppt);
	}
	
	// remove appointments, check for input errors
	public void removeAppointment(String id) {
		if (_apptList.isEmpty()) {
			System.out.println("There are no appointments to remove.");
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (!_apptList.containsKey(id)) {
			throw new IllegalArgumentException("Appointment not found in list");
		}
		else {
			//remove the appointment
			_apptList.remove(id);
			System.out.println("Appointment succesfully removed");
		}
	}

	
		
}
