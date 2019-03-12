package com.vz.spring.batch.bean;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Person implements Serializable {

	private String lastName;
	private String firstName;

	public Person() {
		System.out.println("person default constructor");
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		if(firstName == null)
			this.firstName = "rami reddy ";
		return firstName;
	}

	public String getLastName() {
		if(lastName == null)
			this.lastName = "vakamalla ";
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "firstName: " + firstName + ", lastName: " + lastName;
	}




}
