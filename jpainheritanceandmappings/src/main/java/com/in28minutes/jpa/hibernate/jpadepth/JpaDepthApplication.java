package com.in28minutes.jpa.hibernate.jpadepth;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.jpadepth.entity.FullTimeEmp;
import com.in28minutes.jpa.hibernate.jpadepth.entity.PartTimeEmp;
import com.in28minutes.jpa.hibernate.jpadepth.repository.EmployeeRepo;

@SpringBootApplication
public class JpaDepthApplication implements CommandLineRunner {

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		empRepo.insert(new FullTimeEmp("Jack", new BigDecimal("10000")));
		empRepo.insert(new PartTimeEmp("Jill", new BigDecimal("50")));
		log.info("***All Employees -> {}", empRepo.retrieveAllEmployees());

	}

}
