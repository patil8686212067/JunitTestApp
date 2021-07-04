package com.junit5.junit5_crash_course.model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

	Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();

	public void addContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(firstName, lastName, phoneNumber);
		validateContact(contact);
		checkIfContactAlreadyExist(contact);
		
		
		contactList.put(generateKey(contact), contact);
		//db call will be here
		System.out.println(contactList);
	}

	private void validateContact(Contact contact) {
		contact.validateFirstName();
		contact.validateLastName();
		contact.validatePhoneNumber();
	}

	private void checkIfContactAlreadyExist(Contact contact) {
		if (contactList.containsKey(generateKey(contact))) {
			throw new RuntimeException("Conatact Alreay Exist");
		}
	}

	public String generateKey(Contact contact) {
		return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
	}

	public Collection<Contact> getAllContacts() {
		return contactList.values();
	}
}
