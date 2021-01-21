package com.kodilla.library.repository;

import com.kodilla.library.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {

    @Override
    List<Rental> findAll();

    @Override
    Optional<Rental> findById(Long rentalId);

    @Override
    void deleteById(Long rentalId);
}
