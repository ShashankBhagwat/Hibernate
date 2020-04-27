package com.in28minutes.jpa.hibernate.jpadepth.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.entity.Passport;
import com.in28minutes.jpa.hibernate.jpadepth.entity.Student;

@Repository
@Transactional
public class StudentRepo {

	@Autowired
	EntityManager em;

	public Student findById(long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student s) {
		if (s.getId() == null)
			em.persist(s);
		else
			em.merge(s);

		return s;
	}

	public void deleteById(long id) {
		em.remove(findById(id));
	}

	public void saveStudentWithPassport() {
		Passport p = new Passport("Z123456");
		em.persist(p);
		em.flush();

		Student s = new Student("Mike");
		s.setPassport(p);
		em.persist(s);
		em.flush();

	}

	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("MicroServices");
		em.persist(student);
		em.persist(course);

		course.addStudent(student);
		student.addCourse(course);
		em.persist(student);
	}

	public void insertStudentAndCourse(Student student, Course course) {

		course.addStudent(student);
		student.addCourse(course);

		em.persist(student);
		em.persist(course);

	}

}
