package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalDto {

    private final Long id;
    private final CopyDto copy;
    private final UserDto user;
    private final LocalDate rentDate;
    private final LocalDate returnDate;
}
