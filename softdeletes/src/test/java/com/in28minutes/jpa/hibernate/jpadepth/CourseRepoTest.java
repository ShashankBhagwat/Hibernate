package com.in28minutes.jpa.hibernate.jpadepth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class CourseRepoTest {
	// private org.slf4j.Logger log =
	// org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Autowired
	CourseRepo courseRepo;

	@Test
	@DirtiesContext
	public void testDeleteById() {
		courseRepo.deleteById(10002L);
		assertEquals(null, courseRepo.findById(10002L));
	}

}
