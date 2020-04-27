package com.in28minutes.jpa.hibernate.jpadepth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.repository.CourseSpringDataRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class CourseSpringDataRepoTest {

	@Autowired
	private CourseSpringDataRepo repo;

	@Test
	public void testFindById1() {
		Optional<Course> findById = repo.findById(10001L);
		assertTrue(findById.isPresent());
	}

	@Test
	public void testFindById2() {
		Optional<Course> findById = repo.findById(20001L);
		assertFalse(findById.isPresent());
	}

	@Test
	@Transactional
	@DirtiesContext
	public void test_CRUD() {
		repo.save(new Course("MicroServices"));
		repo.save(new Course("Spring"));
		repo.deleteById(1L);
		assertFalse(repo.findById(1L).isPresent());
		assertEquals("Course [name=Spring]", repo.findById(2L).get().toString());
		assertEquals("[Course [name=Spring], Course [name=JPA], Course [name=Java], Course [name=Python]]",
				repo.findAll().toString());
		assertEquals(4, repo.count());
	}

	@Test
	@Transactional
	@DirtiesContext
	public void test_pagination() {
		PageRequest pageRequest = PageRequest.of(0, 2);
		Page<Course> firstPage = repo.findAll(pageRequest);
		System.out.println("First page-" + firstPage.getContent());
		// First page-[Course [name=JPA], Course [name=Java]]

		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repo.findAll(secondPageable);
		System.out.println("Second page-" + secondPage.getContent());
		// Second page-[Course [name=Python]]
	}

}
