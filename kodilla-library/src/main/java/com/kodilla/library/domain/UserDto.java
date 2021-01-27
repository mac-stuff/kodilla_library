package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserDto {

    private final Long id;
    private final String name;
    private final String surname;
    private final LocalDate date;
}
