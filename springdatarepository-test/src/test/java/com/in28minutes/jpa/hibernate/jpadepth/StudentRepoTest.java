package com.in28minutes.jpa.hibernate.jpadepth;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.entity.Student;
import com.in28minutes.jpa.hibernate.jpadepth.repository.StudentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class StudentRepoTest {
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Autowired
	StudentRepo studentRepo;

	@Test
	@Transactional
	public void retrieveStudentFromCourse() {
		Student student = em.find(Student.class, 20001L);
		log.info("***Student -- > {}", student);
		log.info("***Course for 20001L is -- > {}", student.getCourses());
	}

	@Test
	@Transactional
	public void retrieveCourseFromStudents() {
		Course course = em.find(Course.class, 10002L);
		log.info("***Course -- > {}", course);
		log.info("***Students for 10002L is -- > {}", course.getStudents());
	}

}
