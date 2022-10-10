package com.divya.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "coursename")
    private String courseName;

    @OneToOne
    @JoinColumn(name = "courseId")
    private Course courseId;

    @Column(name = "courcecomplete")
    private boolean isComplete;

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
