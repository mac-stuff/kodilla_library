package com.kodilla.library.repository;

import com.kodilla.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepositoryFindById() {
        //Given
        User user = new User();

        //When
        userRepository.save(user);

        //Then
        Long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryFindAll() {
        //Given
        User user1 = new User();
        User user2 = new User();

        //When
        userRepository.save(user1);
        userRepository.save(user2);

        //Then
        Long id1 = user1.getId();
        Long id2 = user2.getId();
        List<User> listUsers = userRepository.findAll();
        assertEquals(2, listUsers.size());

        //CleanUp
        userRepository.deleteById(id1);
        userRepository.deleteById(id2);
    }

    @Test
    public void testUserRepositoryDeleteById() {
        //Given
        User user1 = new User();
        User user2 = new User();

        //When
        userRepository.save(user1);
        userRepository.save(user2);

        //Then
        Long id1 = user1.getId();
        Long id2 = user2.getId();
        userRepository.deleteById(id2);
        assertEquals(1, userRepository.findAll().size());

        //CleanUp
        userRepository.deleteById(id1);
    }
}