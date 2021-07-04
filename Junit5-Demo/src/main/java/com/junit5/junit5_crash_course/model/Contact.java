package com.junit5.junit5_crash_course.model;

public class Contact {

	private String firstName;
	private String lastName;
	private String phoneNumber;

	public Contact(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void validateFirstName() {
		
		

		if ("".equals(this.firstName) || null==this.firstName) {
			throw new RuntimeException("First Name cannot be null or empty");
		}
	}

	public void validateLastName() {
		
		if ("".equals(this.lastName) || null==this.lastName) {
			throw new RuntimeException("First Last cannot be null or empty");
		}
	}

	public void validatePhoneNumber() {

		if ("".equals(this.phoneNumber) || null==this.phoneNumber) {
			throw new RuntimeException("Phone Number cannot be null or empty");
		}

		if (this.phoneNumber.length() != 10) {
			throw new RuntimeException("Phone Number Should be 0 digit long");
		}

		if (!this.phoneNumber.matches("\\d+")) {
			throw new RuntimeException("Phone Number Contains only digit");
		}

		if (!this.phoneNumber.startsWith("0")) {
			throw new RuntimeException("Phone Name should be start with 0");
		}
	}
}

