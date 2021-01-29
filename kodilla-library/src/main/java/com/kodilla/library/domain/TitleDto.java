package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class TitleDto {

    private final Long id;
    private final String title;
    private final String author;
    private final LocalDate publicationDate;
    public List<CopyDto> copies;
}
