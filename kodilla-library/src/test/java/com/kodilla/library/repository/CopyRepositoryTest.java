package com.kodilla.library.repository;

import com.kodilla.library.domain.Copy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CopyRepositoryTest {

    @Autowired
    private CopyRepository copyRepository;

    @Test
    public void testCopyRepositoryFindById() {
        //Given
        Copy copy = new Copy();

        //When
        copyRepository.save(copy);

        //Then
        Long id = copy.getId();
        Optional<Copy> readCopy = copyRepository.findById(id);
        assertTrue(readCopy.isPresent());

        //CleanUp
        copyRepository.deleteById(id);
    }

    @Test
    public void testCopyRepositoryFindAll() {
        //Given
        Copy copy1 = new Copy();
        Copy copy2 = new Copy();

        //When
        copyRepository.save(copy1);
        copyRepository.save(copy2);

        //Then
        Long id1 = copy1.getId();
        Long id2 = copy2.getId();
        List<Copy> listCopies = copyRepository.findAll();
        assertEquals(2, listCopies.size());

        //CleanUp
        copyRepository.deleteById(id1);
        copyRepository.deleteById(id2);
    }

    @Test
    public void testCopyRepositoryDeleteById() {
        //Given
        Copy copy1 = new Copy();
        Copy copy2 = new Copy();

        //When
        copyRepository.save(copy1);
        copyRepository.save(copy2);

        //Then
        Long id1 = copy1.getId();
        Long id2 = copy2.getId();
        copyRepository.deleteById(id2);
        assertEquals(1, copyRepository.findAll().size());

        //CleanUp
        copyRepository.deleteById(id1);
    }

    @Test
    public void testCopyRepositoryCreate() {
        //Given
        Copy copy = new Copy();

        //When
        copyRepository.save(copy);

        //Then
        Long id = copy.getId();
        assertEquals(1, copyRepository.findAll().size());

        //CleanUp
        copyRepository.deleteById(id);
    }
}
