package com.in28minutes.jpa.hibernate.jpadepth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.jpa.hibernate.jpadepth.entity.Course;

@RepositoryRestResource(path = "courses")
public interface SpringDataRepo extends JpaRepository<Course, Long> {
}
