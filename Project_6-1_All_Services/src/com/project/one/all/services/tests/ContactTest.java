package com.project.one.all.services.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.one.all.services.Contact;

class ContactTest {

	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", null, null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", "A", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", "A", "7022085900", null);
		});
	}
	
	@Test
	void testContactInvalidArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "ListoolongName", "A", "7022085900", "602 Elms");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", "AistoolongName", "7022085900", "602 Elms");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", "A", "7022085900istoolongNumber", "602 Elms");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", "A", "tooshort", "602 Elms");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567898", "L", "A", "7022085900", "602_Elms_istoolongan_address_to_be_-valid_for_this");
		});
	}
	
	@Test
	void testContactGetters() {
		Contact c = new Contact("123456789", "L", "A", "7022084900", "602 Elm St");
		Assertions.assertEquals(c.getId(), "123456789");
		Assertions.assertEquals(c.getFullName(), "L A");
		Assertions.assertEquals(c.getPhoneNumber(), "7022084900");
		Assertions.assertEquals(c.getAddress(), "602 Elm St");
	}
}
