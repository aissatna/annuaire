package com.example.annuaire.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Person {
    @Id
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String city;

    public Person(String name, String surname, String phone, String city) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
    }
}
