package com.in28minutes.jpa.hibernate.jpadepth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
class JpaDepthApplicationTests {

	@Autowired
	CourseRepo courseRepo;

	@Test
	public void testFindById() {
		assertEquals("JPA", courseRepo.findById(10001).getName());
	}

	@Test
	@DirtiesContext
	public void testDeleteById() {
		assertEquals(null, courseRepo.findById(10003));
	}

	@Test
	@DirtiesContext
	public void testSave() {
		assertEquals("Microservices", courseRepo.findById(1).getName());
	}

//	@Test
//	@DirtiesContext
//	public void testPlay() {
//		courseRepo.playWithEntityManager();
//	}

}
