package com.in28minutes.database.databasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.jpa.PersonJpaDao;
import com.in28minutes.database.databasedemo.jpa.entity.Person;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.findById(10001));
		System.out.println(dao.insert(new Person("Shashank", "Hyderabad")));
		System.out.println(dao.update(new Person("Shashank", "Amsterdam")));
		System.out.println(dao.findAll());
		dao.delete(1);
		System.out.println(dao.findAll());
	}

}
