package com.in28minutes.database.databasedemo.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jdbc.entity.Person;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	PersonJdbcDao dao;

	@GetMapping("/persons")
	public List<Person> allPersons() {
		return dao.findAll();
	}

	@GetMapping(path = "/persons/{id}")
	public Person allPersons(@PathVariable(value = "id") int id) {
		return dao.findById(id);
	}
}
