package com.milestone.three.contact.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.milestone.three.contact.Contact;

class ContactTest {

	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
			
	}
	
	@Test
	void testContactAndGetters() {
		Contact contact = new Contact("123456", "Lawrence", "Dominguez", "7025554900", "6029 Elm Street");
		assertTrue(contact.getFullName().equals("Lawrence Dominguez"));
		assertTrue(contact.getPhoneNumber().equals("7025554900"));
		assertTrue(contact.getAddress().equals("6029 Elm Street"));
		assertTrue(contact.getId().equals("123456"));
	}
	
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("123456", "Lawrence", "Dominguez", "7025554900", "6029 Elm Street");
		contact.setFirstName("Lorenzo");
		contact.setLastName("Day");
		assertTrue(contact.getFullName().equals("Lorenzo Day"));
	}
	
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("123456", "Lawrence", "Dominguez", "7025554900", "6029 Elm Street");
		contact.setPhoneNumber("7024595355");
		contact.setAddress("1881 W Alexander Rd");
		assertTrue(contact.getPhoneNumber().equals("7024595355"));
		assertTrue(contact.getAddress().equals("1881 W Alexander Rd"));
	}
	
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("123456", "Lawrence", "Dominguez", "7025554900", "6029 Elm Street");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	void testAllGetters() {
		Contact contact = new Contact("123456", "Lawrence", "Dominguez", "7025554900", "6029 Elm Street");
		assertTrue(contact.getFullName().equals("Lawrence Dominguez"));
		assertTrue(contact.getId().equals("123456"));
		assertTrue(contact.getPhoneNumber().equals("7025554900"));
		assertTrue(contact.getAddress().equals("6029 Elm Street"));
	}

}
