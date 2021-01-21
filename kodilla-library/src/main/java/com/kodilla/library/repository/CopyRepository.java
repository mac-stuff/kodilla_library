package com.kodilla.library.repository;

import com.kodilla.library.domain.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    List<Copy> findAll();

    @Override
    Optional<Copy> findById(Long copyId);

    @Override
    void deleteById(Long copyId);
}
