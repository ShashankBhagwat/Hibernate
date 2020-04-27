package com.in28minutes.jpa.hibernate.jpadepth.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmp extends Employee {

	private BigDecimal salary;

	public FullTimeEmp() {
	}

	public FullTimeEmp(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FullTimeEmp [salary=" + salary + "]";
	}

}
