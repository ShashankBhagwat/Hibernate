package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jdbc.entity.Person;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.findAll());
		System.out.println(dao.findById(10001));
		System.out.println(dao.deleteById(10003));
		System.out.println(dao.insert(new Person(10004, "Manasa", "Hyderabad", new Date())));
		System.out.println(dao.update(new Person(10005, "Shashank", "Hyderabad", new Date())));
	}

}
