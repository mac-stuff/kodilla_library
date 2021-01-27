package com.kodilla.library.service;

import com.kodilla.library.domain.Rental;
import com.kodilla.library.domain.Title;
import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.User;
import com.kodilla.library.repository.RentalRepository;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.repository.CopyRepository;
import com.kodilla.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private RentalRepository rentalRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }


    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Optional<Title> getTitle(final Long id) {
        return titleRepository.findById(id);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitle(final Long TitleId) {
        titleRepository.deleteById(TitleId);
    }


    public List<Copy> getAllCopies() {
        return copyRepository.findAll();
    }

    public Optional<Copy> getCopy(final Long id) {
        return copyRepository.findById(id);
    }

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public void deleteCopy(final Long copyId) {
        copyRepository.deleteById(copyId);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRental(final Long id) {
        return rentalRepository.findById(id);
    }

    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(final Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}
