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

    private String name;
    private int population;
}
