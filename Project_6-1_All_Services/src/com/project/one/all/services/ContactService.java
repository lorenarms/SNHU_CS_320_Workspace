package com.project.one.all.services;

import java.util.HashMap;

public class ContactService {

	private HashMap<String, Contact> _contactList = new HashMap<String, Contact>();
	
	public HashMap<String, Contact> getContactList(){
		return _contactList;
	}
	
	public void printContactList() {
		for(Contact c : _contactList.values()) {
			System.out.println(c.getFullName());
		}
	}
	
	public void AddContact(String fName, String lName, String phone, String addy) {
		String id = UniqueIDGenerator.generateUniqueID();
		if (_contactList.size() >= UniqueIDGenerator.getMaxEntries()) {
			throw new IllegalArgumentException("Contact list is full!");
		}
		while (_contactList.containsKey(id)) {
			id = UniqueIDGenerator.generateUniqueID();
		}
		Contact contact = new Contact(id, fName, lName, phone, addy);
		_contactList.put(contact.getId(), contact);		
	}
	
	
	public void DeleteContact(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(_contactList.isEmpty()) {
			throw new IllegalArgumentException("No contacts to delete");
		}
		
		if(!_contactList.containsKey(id)) {
			throw new IllegalArgumentException("Contact does not exist");
		}
		
		else{
			_contactList.remove(id);
			System.out.println("Contact removed from list.");
		}
		
	}
	
		public void UpdateContact(String id, Contact contact) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(contact == null) {
			throw new IllegalArgumentException("Invalid contacts");
		}
		
		if(_contactList.isEmpty()) {
			throw new IllegalArgumentException("No contacts exist in list");
		}
		
		if(!_contactList.containsKey(id)) {
			throw new IllegalArgumentException("That contact is not in the list");
		}
		
		else {
			_contactList.replace(id, contact);
		}
			
	}
		
}
