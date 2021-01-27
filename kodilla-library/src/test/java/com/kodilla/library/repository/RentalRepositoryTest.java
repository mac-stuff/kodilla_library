package com.kodilla.library.repository;

import com.kodilla.library.domain.Rental;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentalRepositoryTest {

    @Autowired
    private RentalRepository rentalRepository;

    @Test
    public void testRentalRepositoryFindById() {
        //Given
        Rental rental = new Rental();

        //When
        rentalRepository.save(rental);

        //Then
        Long id = rental.getId();
        Optional<Rental> readRental = rentalRepository.findById(id);
        assertTrue(readRental.isPresent());

        //CleanUp
        rentalRepository.deleteById(id);
    }

    @Test
    public void testRentalRepositoryFindAll() {
        //Given
        Rental rental1 = new Rental();
        Rental rental2 = new Rental();

        //When
        rentalRepository.save(rental1);
        rentalRepository.save(rental2);

        //Then
        Long id1 = rental1.getId();
        Long id2 = rental2.getId();
        List<Rental> listRentals = rentalRepository.findAll();
        assertEquals(2, listRentals.size());

        //CleanUp
        rentalRepository.deleteById(id1);
        rentalRepository.deleteById(id2);
    }

    @Test
    public void testRentalRepositoryDeleteById() {
        //Given
        Rental rental1 = new Rental();
        Rental rental2 = new Rental();

        //When
        rentalRepository.save(rental1);
        rentalRepository.save(rental2);

        //Then
        Long id1 = rental1.getId();
        Long id2 = rental2.getId();
        rentalRepository.deleteById(id2);
        assertEquals(1, rentalRepository.findAll().size());

        //CleanUp
        rentalRepository.deleteById(id1);
    }

    @Test
    public void testRentalRepositoryCreate() {
        //Given
        Rental rental = new Rental();

        //When
        rentalRepository.save(rental);

        //Then
        Long id = rental.getId();
        assertEquals(1, rentalRepository.findAll().size());

        //CleanUp
        rentalRepository.deleteById(id);
    }
}
