package com.in28minutes.jpa.hibernate.jpadepth.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;

@Repository
@Transactional
public class CourseRepo {

	@Autowired
	EntityManager manager;

	public Course findById(long id) {
		return manager.find(Course.class, id);
	}

	public Course save(Course c) {
		if (c.getId() == null)
			manager.persist(c);
		else
			manager.merge(c);

		return c;
	}

	public void deleteById(long id) {
		manager.remove(findById(id));
	}

//	public void playWithEntityManager() {
//		Course course1 = new Course("Micro Services");
//		manager.persist(course1);
//		course1.setName("Micro Services - Updated");
//		manager.flush();
//
//		Course course2 = new Course("Angular");
//		manager.persist(course2);
//		manager.detach(course2);
//		manager.flush();
//
//		course2.setName("Angular - Updated");
//
//	}

}
