package com.kodilla.library.mapper;

import com.kodilla.library.domain.Rental;
import com.kodilla.library.domain.RentalDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalMapper {

    public Rental mapToRental(final RentalDto rentalDto) {
        return new Rental(
                rentalDto.getId(),
                rentalDto.getCopy(),
                rentalDto.getUser(),
                rentalDto.getRentDate(),
                rentalDto.getReturnDate()
        );
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getCopy(),
                rental.getUser(),
                rental.getRentDate(),
                rental.getReturnDate()
        );
    }

    public List<RentalDto> mapToRentalsDtoList(final List<Rental> rentalList) {
        return rentalList.stream()
                .map(this::mapToRentalDto)
                .collect(Collectors.toList());
    }
}
