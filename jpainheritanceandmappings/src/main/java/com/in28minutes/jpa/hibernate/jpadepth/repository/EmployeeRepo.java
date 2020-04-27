package com.in28minutes.jpa.hibernate.jpadepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Employee;

@Repository
@Transactional
public class EmployeeRepo {

	// private org.slf4j.Logger log =
	// org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Employee insert(Employee c) {
		em.persist(c);
		return c;
	}

	public List<Employee> retrieveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
}
