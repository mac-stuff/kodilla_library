package com.kodilla.library.mapper;

import com.kodilla.library.domain.Rental;
import com.kodilla.library.domain.RentalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CopyMapper copyMapper;

    public Rental mapToRental(final RentalDto rentalDto) {
        return new Rental(
                rentalDto.getId(),
                copyMapper.mapToCopy(rentalDto.getCopyDto()),
                userMapper.mapToUser(rentalDto.getUserDto()),
                rentalDto.getRentDate(),
                rentalDto.getReturnDate()
        );
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        return new RentalDto(
                rental.getId(),
                copyMapper.mapToCopyDto(rental.getCopy()),
                userMapper.mapToUserDto(rental.getUser()),
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
