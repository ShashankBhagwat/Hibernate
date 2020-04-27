package com.in28minutes.jpa.hibernate.jpadepth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.entity.Rating;
import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class CourseRepoTest {
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Autowired
	CourseRepo courseRepo;

	@Test
	public void testFindById() {
		assertEquals("Course [name=JPA]", em.find(Course.class, 10001L));
	}

	@Test
	@DirtiesContext
	public void testDeleteById() {
		courseRepo.deleteById(10003L);
		assertEquals(null, courseRepo.findById(10003L));
	}

	@Test
	@Transactional
	@DirtiesContext
	public void testSave() {
		courseRepo.save(new Course("Microservices"));
	}

	@Test
	@Transactional
	public void retrieveRatingsForCourse() {
		Course course = em.find(Course.class, 10003L);
		log.info("ratings for 10003 are -- > {}", course.getRatings());
	}

	@Test
	@Transactional
	public void retrieveCourseForRating() {
		Rating rating = em.find(Rating.class, 50001L);
		log.info("Course for 50001L is -- > {}", rating.getCourse());
	}

}
