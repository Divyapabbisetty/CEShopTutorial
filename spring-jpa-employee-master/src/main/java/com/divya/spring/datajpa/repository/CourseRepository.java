package com.divya.spring.datajpa.repository;

import com.divya.spring.datajpa.model.Course;
import com.divya.spring.datajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
