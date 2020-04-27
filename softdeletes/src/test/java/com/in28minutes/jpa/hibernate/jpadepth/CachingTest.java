package com.in28minutes.jpa.hibernate.jpadepth;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class CachingTest {

	@Autowired
	EntityManager em;

	@Autowired
	CourseRepo courseRepo;

	@Test
	public void testFindById1() {
		/*
		 * select course0_.id as id1_0_0_, course0_.name as name2_0_0_ from course
		 * course0_ where course0_.id=?
		 */
		// Executed twice
		courseRepo.findById(10001L);
		System.out.println("***Qeury executed");

		courseRepo.findById(10001L);
		System.out.println("***Qeury executed again");
	}

	@Test
	@Transactional
	public void testFindById2() {
		/*
		 * select course0_.id as id1_0_0_, course0_.name as name2_0_0_ from course
		 * course0_ where course0_.id=?
		 */
		// Executed only once
		courseRepo.findById(10001L);
		System.out.println("***Qeury executed");

		courseRepo.findById(10001L);
		System.out.println("***Qeury executed again");
	}

}
