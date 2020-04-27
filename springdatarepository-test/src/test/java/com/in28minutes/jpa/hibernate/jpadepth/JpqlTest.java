package com.in28minutes.jpa.hibernate.jpadepth;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class JpqlTest {

	@Autowired
	EntityManager em;

	@Test
	public void test_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
		List<Course> coursesWithoutStudentsList = query.getResultList();
		System.out.println("***Result -->" + coursesWithoutStudentsList.toString());
	}

	@Test
	public void test_courses_atleast_2_students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> coursesWithoutStudentsList = query.getResultList();
		System.out.println("***Result -->" + coursesWithoutStudentsList.toString());
	}

	@Test
	public void test_courses_ordered_by_students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc",
				Course.class);
		List<Course> coursesWithoutStudentsList = query.getResultList();
		System.out.println("***Result -->" + coursesWithoutStudentsList.toString());
	}

	@Test
	public void test_courses_like_example_students() {
		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%9763%'",
				Student.class);
		List<Student> coursesWithoutStudentsList = query.getResultList();
		System.out.println("***Result -->" + coursesWithoutStudentsList.toString());
	}

	// between
	// is null
	// upper,lower,trim,length
	@Test
	public void test_join() {
		Query query = em.createQuery("select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("***Result -->");
		for (Object[] obj : resultList) {
			System.out.println(obj[0] + " " + obj[1]);
		}
		// no python in output
	}

	@Test
	public void test_left_join() {
		Query query = em.createQuery("select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("***Result -->");
		for (Object[] obj : resultList) {
			System.out.println(obj[0] + " " + obj[1]);
		}
//		Course [name=JPA] Student [id=20001, name=Shashank]
//				Course [name=JPA] Student [id=20002, name=Manasa]
//				Course [name=JPA] Student [id=20003, name=keerthi]
//				Course [name=Java] Student [id=20001, name=Shashank]
//				Course [name=Java] Student [id=20002, name=Manasa]
//				Course [name=Python] null
	}

	@Test
	public void test_cross_join() {
		Query query = em.createQuery("select c,s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("***Result -->");
		for (Object[] obj : resultList) {
			System.out.println(obj[0] + " " + obj[1]);
		}
	}
//	Course [name=JPA] Student [id=20001, name=Shashank]
//			Course [name=JPA] Student [id=20002, name=Manasa]
//			Course [name=JPA] Student [id=20003, name=keerthi]
//			Course [name=Java] Student [id=20001, name=Shashank]
//			Course [name=Java] Student [id=20002, name=Manasa]
//			Course [name=Java] Student [id=20003, name=keerthi]
//			Course [name=Python] Student [id=20001, name=Shashank]
//			Course [name=Python] Student [id=20002, name=Manasa]
//			Course [name=Python] Student [id=20003, name=keerthi]
}
