package com.divya.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "coursetype")
    private String courseType;
}
