package com.divya.spring.datajpa.repository;

import com.divya.spring.datajpa.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    List<StudentCourse> findByStudent(Long studentId);
}
