package com.kodilla.library.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LIBRARY_USERS")
public class User {

    public User(Long id, String name, String surname, LocalDate date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
    }

    public User(String name, String surname, LocalDate date) {
        this.name = name;
        this.surname = surname;
        this.date = date;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "DATE")
    private LocalDate date;
}
