package com.milestone.five.appointment.service;

import java.util.Date;
import java.util.Random;
import java.util.Vector;


public class AppointmentService {
	
	private Vector<Appointment> _apptList = new Vector<Appointment>();
	private int _apptCount = 0;

	// getters
	public Vector<Appointment> GetAppointmentList(){
		return _apptList;
	}
	public int GetAppointmentCount() {
		return _apptCount;
	}
	// print appointments (for console debugging)
	public void PrintAppointmentList() {
		for (Appointment a : _apptList) {
			System.out.println("Appointment ID: " + a.GetID() +
					"\nAppointment Date: " + a.GetApptDate().toString() +
					"\nAppointment Description: " + a.GetDescription());
		}
	}
	
	// add appointments, check for input errors
	public void AddAppointment(Date date, String description) {
		Date today = new Date();
		if (date == null || date.before(today)) {
			throw new IllegalArgumentException("Invalid Appointmene Date");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
			
		}
		String newID = GenerateUniqueID();
		var newAppt = new Appointment(newID, date, description);
		_apptList.add(newAppt);
		_apptCount = GetAppointmentCount() + 1;
		//System.out.println("Appointment " + description + " created.");
	}
	
	// remove appointments, check for input errors
	public void RemoveAppointment(String id) {
		if (_apptList.isEmpty()) {
			System.out.println("There are no appointments to remove.");
			
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
			
		}
		
		// search id's for specified appointment
		int index = -1;
		for (Appointment a : _apptList) {
			if (a.GetID() == id) {
				index = _apptList.indexOf(a);
			}
			
		}
		// appointment wasn't found
		if (index == -1) {
			System.out.println("Appointment ID not found.");
			return;
		}
		else {
			//remove the appointment
			_apptList.remove(index);
			_apptCount = GetAppointmentCount() - 1;
			System.out.println("Appointment succesfully removed");
		}
	}
	
	// generate a unique id number for the created appointment
	// "if it ain't broke, don't fix it" right?
	public String GenerateUniqueID(/*int mult*/) {
		// randomize number with 9 - 10 digits
		
		//if (mult < 1) {
		//	mult = 1000000000;
		//}
		int count = 0;
		
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		// temporary vector of strings for ids
		Vector<String> idList = new Vector<String>();
		// fill vector with existing ids
		for (Appointment a : _apptList) {
			idList.add(a.GetID());
		}
		
		// compare newly created id to list of existing
		while (idList.contains(uniqueID) || uniqueID.length() > 10) {
			// if match was found, create a new id
			newID = rand.nextInt(1000000000);
			uniqueID = Integer.toString(newID);
			count++;
			if (count > 1000000000) {
				System.out.println("No more id's available");
				break;
			}
		}
		// remove temp vector
		idList = null;
		// return created id
		return uniqueID;
	}
	
	
}
