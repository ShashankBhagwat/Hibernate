package com.in28minutes.jpa.hibernate.jpadepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;
import com.in28minutes.jpa.hibernate.jpadepth.entity.Rating;

@Repository
@Transactional
public class CourseRepo {

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Course findById(long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course c) {
		if (c.getId() == null)
			em.persist(c);
		else
			em.merge(c);

		return c;
	}

	public void deleteById(long id) {
		em.remove(findById(id));
	}

	public void addHardCodedReviewsForCourse() {
		Course course = findById(10003L);
		log.info("course 10003 ratings **** {}", course.getRatings());
		Rating rating1 = new Rating("3", "Moderate Again Putting");
		rating1.setCourse(course);
		Rating rating2 = new Rating("2", "Below Average Putting");
		rating2.setCourse(course);

		course.addRating(rating2);
		course.addRating(rating1);

		em.persist(rating1);
		em.persist(rating2);
	}

	public void addReviewsForCourse(Long id, List<Rating> ratings) {
		Course course = findById(id);
		log.info("***course " + id + " +ratings --> {}", course.getRatings());

		for (Rating r : ratings) {
			course.addRating(r);
			r.setCourse(course);
			em.persist(r);
		}

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
