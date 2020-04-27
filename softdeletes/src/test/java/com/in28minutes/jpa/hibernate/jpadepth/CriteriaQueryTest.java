package com.in28minutes.jpa.hibernate.jpadepth;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class CriteriaQueryTest {

	@Autowired
	EntityManager em;

	@Test
	public void test_select() {
		// select c from Course c
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> root = cq.from(Course.class);

		TypedQuery<Course> query = em.createQuery(cq.select(root));
		List<Course> list = query.getResultList();
		System.out.println("***Result -->" + list.toString());
	}

	@Test
	public void test_courses_starting_with_J() {
		// select c from Course c where name like "J%"
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> root = cq.from(Course.class);
		Predicate like = cb.like(root.get("name"), "J%");
		cq.where(like);

		TypedQuery<Course> query = em.createQuery(cq.select(root));
		List<Course> list = query.getResultList();
		System.out.println("***Result -->" + list.toString());
		// ***Result -->[Course [name=JPA], Course [name=Java]]
	}

	@Test
	public void test_courses_without_students() {
		// select c from Course c where c.students is empty
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> root = cq.from(Course.class);
		Predicate p = cb.isEmpty(root.get("students"));
		cq.where(p);

		TypedQuery<Course> query = em.createQuery(cq.select(root));
		List<Course> list = query.getResultList();
		System.out.println("***Result -->" + list.toString());
		// ***Result -->[Course [name=Python]]
	}

	@Test
	public void test_join() {
		// select c from Course c join c.students s
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> root = cq.from(Course.class);
		Join<Object, Object> join = root.join("students");

		TypedQuery<Course> query = em.createQuery(cq.select(root));
		List<Course> list = query.getResultList();
		System.out.println("***Result -->" + list.toString());
		// ***Result -->[Course [name=JPA], Course [name=Java], Course [name=JPA],
		// Course [name=Java], Course [name=JPA]]
	}

	@Test
	public void test_left_join() {
		// select c from Course c left join c.students s
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> root = cq.from(Course.class);
		Join<Object, Object> join = root.join("students", JoinType.LEFT);

		TypedQuery<Course> query = em.createQuery(cq.select(root));
		List<Course> list = query.getResultList();
		System.out.println("***Result -->" + list.toString());
		// ***Result -->[Course [name=JPA], Course [name=JPA], Course [name=JPA], Course
		// [name=Java], Course [name=Java], Course [name=Python]]
	}
}
