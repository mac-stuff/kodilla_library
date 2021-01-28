package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalDto {

    private final Long id;
    private final CopyDto copyDto;
    private final UserDto userDto;
    private final LocalDate rentDate;
    private final LocalDate returnDate;
}
