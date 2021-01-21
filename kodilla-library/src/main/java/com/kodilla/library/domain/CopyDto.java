package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopyDto {

    private final Long id;
    private final Title title;
    private final Rental rental;
    private final Boolean isBorrow;
}
