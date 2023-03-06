package com.app.postgresapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "years_of_experience")
    private int experience;
}
