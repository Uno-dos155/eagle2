package com.bird.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "surname")
    @Size(min = 1, max = 14)
    private String surname;

    @Email
    private String email;

    @NotBlank
    @Size(min = 12, max = 12)
    private String iin;

    @NotBlank
    private String phone;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public Person(int id, @NotBlank String name, @NotBlank @Size(min = 1, max = 14) String surname, @Email String email, @NotBlank @Size(min = 12, max = 12) String iin, @NotBlank String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.iin = iin;
        this.phone = phone;
    }
}
