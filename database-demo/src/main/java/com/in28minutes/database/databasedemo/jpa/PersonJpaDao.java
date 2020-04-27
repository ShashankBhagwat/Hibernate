package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.jpa.entity.Person;

@Repository
@Transactional
public class PersonJpaDao {

	@Autowired
	EntityManager entityManager;

	public List<Person> findAll() {
		return entityManager.createNamedQuery("find_all_persons", Person.class).getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person update(Person p) {
		return entityManager.merge(p);
	}

	public Person insert(Person p) {
		return entityManager.merge(p);
	}

	public void delete(int id) {
		Person p = findById(id);
		entityManager.remove(p);
	}
}
