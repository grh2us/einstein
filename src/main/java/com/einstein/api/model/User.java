package com.einstein.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}
