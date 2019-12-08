package com.einstein.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by owenkhoury on 11/20/19.
 */
@Entity
@Data
public class Tutor {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "school")
    private String school;

    @Column(name = "expertise")
    private String expertise;

    @Column(name = "hoursWorked")
    private int hoursWorked;

    @Column(name = "major")
    private String major;
}
