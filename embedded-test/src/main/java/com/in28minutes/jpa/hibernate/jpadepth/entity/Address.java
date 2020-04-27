package com.in28minutes.jpa.hibernate.jpadepth.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;

	public Address() {
	}

	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}
}
