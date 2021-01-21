package com.kodilla.library.repository;

import com.kodilla.library.domain.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TitleRepositoryTest {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void testBookRepositoryFindById() {
        //Given
        Title title = new Title();
        //When
        titleRepository.save(title);

        //Then
        Long id = title.getId();
        Optional<Title> readBook = titleRepository.findById(id);
        assertTrue(readBook.isPresent());

        //CleanUp
        titleRepository.deleteById(id);
    }

    @Test
    public void testBookRepositoryFindAll() {
        //Given
        Title title1 = new Title();
        Title title2 = new Title();

        //When
        titleRepository.save(title1);
        titleRepository.save(title2);

        //Then
        Long id1 = title1.getId();
        Long id2 = title2.getId();
        List<Title> listTitles = titleRepository.findAll();
        assertEquals(2, listTitles.size());

        //CleanUp
        titleRepository.deleteById(id1);
        titleRepository.deleteById(id2);
    }

    @Test
    public void testBookRepositoryDeleteById() {
        //Given
        Title title1 = new Title();
        Title title2 = new Title();

        //When
        titleRepository.save(title1);
        titleRepository.save(title2);

        //Then
        Long id1 = title1.getId();
        Long id2 = title2.getId();
        titleRepository.deleteById(id2);
        assertEquals(1, titleRepository.findAll().size());

        //CleanUp
        titleRepository.deleteById(id1);
    }
}