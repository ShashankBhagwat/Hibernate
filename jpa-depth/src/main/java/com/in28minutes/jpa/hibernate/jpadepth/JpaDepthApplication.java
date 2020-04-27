package com.in28minutes.jpa.hibernate.jpadepth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseRepo;

@SpringBootApplication
public class JpaDepthApplication implements CommandLineRunner {

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepo courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("***Course 10001 -> {}", courseRepo.findById(10001L));
		log.info("***Course Adding -> {}", courseRepo.save(new Course("Microservices")));
		courseRepo.deleteById(10003L);

	}

}
