package com.in28minutes.jpa.hibernate.jpadepth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	// There will be duplications of columns in both student and Passport if we make
	// this var as OneToOne. So, to restrict the duplication we make one table own
	// everything.So, to own we use mappedBy. mappedBy is used in non-own class and
	// should declare the variable used in owning class.
	private Student student;

	public Passport() {
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + "]";
	}
}
