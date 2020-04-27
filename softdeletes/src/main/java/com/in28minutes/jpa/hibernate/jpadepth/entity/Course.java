package com.in28minutes.jpa.hibernate.jpadepth.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.cache.annotation.Cacheable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private List<Rating> ratings = new ArrayList<>();

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	@Column(nullable = false)
	private boolean isDeleted = false;

	@PreRemove
	public void preRemove() {
		isDeleted = true;
	}

	public Course() {
	}

	public Course(String name) {
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void addRating(Rating reviews) {
		this.ratings.add(reviews);
	}

	public void removeRating(Rating reviews) {
		this.ratings.remove(reviews);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", ratings=" + ratings + ", students=" + students
				+ ", isDeleted=" + isDeleted + "]";
	}

}
