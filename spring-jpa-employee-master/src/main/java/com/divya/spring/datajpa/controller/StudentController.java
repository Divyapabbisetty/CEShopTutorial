package com.divya.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.divya.spring.datajpa.model.Student;
import com.divya.spring.datajpa.model.StudentCourse;
import com.divya.spring.datajpa.repository.StudentCourseRepository;
import com.divya.spring.datajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divya.spring.datajpa.model.Employee;
import com.divya.spring.datajpa.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Employee> tutorials = new ArrayList<Employee>();

			if (title == null)
				employeeRepository.findAll().forEach(tutorials::add);
			else
				employeeRepository.findByFirstNameContaining(title).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getTutorialById(@PathVariable("id") long id) {
		Optional<Student> tutorialData = studentRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			Student _tutorial = studentRepository
					.save(new Student(student.getFirstName(), student.getLastName()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<StudentCourse> addStudentCourse(@PathVariable("id") long id, @RequestBody StudentCourse tutorial) {
		Optional<Student> tutorialData = studentRepository.findById(id);

		if (tutorialData.isPresent()) {
			Student _tutorial = tutorialData.get();
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setStudent(_tutorial);
			studentCourse.setCourseId(tutorial.getCourseId());
			studentCourse.setCourseName(tutorial.getCourseName());
			return new ResponseEntity<>(studentCourseRepository.save(studentCourse), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/students")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			employeeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/tutorials/onbench")
	public ResponseEntity<List<Employee>> findByPublished() {
		try {
			List<Employee> tutorials = employeeRepository.findByOnBench(true);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{studentId}/studentCourses")
	public ResponseEntity<List<StudentCourse>> getAllCoursesForStudent(@PathVariable("studentId") long studentId) {
		try {
			List<StudentCourse> courseList = studentCourseRepository.findByStudent(studentId);

			if (courseList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(courseList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
