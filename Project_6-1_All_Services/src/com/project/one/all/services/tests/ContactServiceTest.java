package com.project.one.all.services.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.one.all.services.Contact;
import com.project.one.all.services.ContactService;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService c = new ContactService();
		c.AddContact("F", "L", "7022084900", "Addy");
		Assertions.assertTrue(!c.getContactList().isEmpty());
		c.printContactList();
	}
	
	@Test
	void testUpdateContact() {
		ContactService c = new ContactService();
		
		String id = "";
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact(null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("12345678900101", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("123456789", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("123456789", new Contact("12", "L", "A", "1234567890", "Add"));
		});
		
		c.AddContact("F", "L", "7022084900", "Addy");
		for(Contact d : c.getContactList().values()) {
			id = d.getId();
		}
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("123456789", new Contact("12", "L", "A", "1234567890", "Add"));
		});
		
		c.UpdateContact(id, new Contact(id, "L", "A", "1234567890", "Add"));
		
	}
	
	@Test
	void testDeleteContact() {
		ContactService c = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact("12345678901010");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact("1234567890");
		});
		
		String id = null;
		c.AddContact("F", "L", "7022084900", "Addy");
		for(Contact d : c.getContactList().values()) {
			id = d.getId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact("1234567890");
		});
		
		c.DeleteContact(id);
		Assertions.assertTrue(c.getContactList().isEmpty());
		
	}

}
