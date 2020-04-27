package com.in28minutes.jpa.hibernate.jpadepth.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmp extends Employee {

	private BigDecimal hourlyWage;

	public PartTimeEmp() {
	}

	public PartTimeEmp(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmp [hourlyWage=" + hourlyWage + "]";
	}

}
