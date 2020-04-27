package com.in28minutes.jpa.hibernate.jpadepth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseRepo;

@SpringBootApplication
public class JpaDepthApplication implements CommandLineRunner {

	// private org.slf4j.Logger log =
	// org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepo courseRepo;
//
//	@Autowired
//	private StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		log.info("***Course 10001 -> {}", courseRepo.findById(10001L));
//		log.info("***Course Adding -> {}", courseRepo.save(new Course("Microservices")));
//
//		studentRepo.saveStudentWithPassport();

		// courseRepo.addHardCodedReviewsForCourse();
		/*
		 * List<Rating> ratings = new ArrayList<Rating>(); ratings.add(new Rating("5",
		 * "Excellent")); courseRepo.addReviewsForCourse(10003L, ratings);
		 */

		// studentRepo.insertHardCodedStudentAndCourse();
//		Student student = new Student("Jack-Updated");
//		Course course = new Course("MicroServices-Updated");
//		studentRepo.insertStudentAndCourse(student, course);
		courseRepo.findById(10001L);
		courseRepo.findById(10002L);
	}

}
