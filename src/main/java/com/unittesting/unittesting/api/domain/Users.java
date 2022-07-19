package com.unittesting.unittesting.api.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Entity @Table(name = "users") @Getter @Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Users(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
