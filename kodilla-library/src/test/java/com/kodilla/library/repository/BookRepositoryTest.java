package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBookRepositoryFindById() {
        //Given
        Book Book = new Book("Jan", "Nowak", LocalDate.of(2020, 1, 8));

        //When
        bookRepository.save(Book);

        //Then
        Long id = Book.getId();
        Optional<Book> readBook = bookRepository.findById(id);
        assertTrue(readBook.isPresent());

        //CleanUp
        bookRepository.deleteById(id);
    }

    @Test
    public void testBookRepositoryFindAll() {
        //Given
        Book Book1 = new Book("Jan", "Nowak", LocalDate.of(2020, 1, 8));
        Book Book2 = new Book("Anna", "Nowak", LocalDate.of(2021, 1, 13));

        //When
        bookRepository.save(Book1);
        bookRepository.save(Book2);

        //Then
        Long id1 = Book1.getId();
        Long id2 = Book2.getId();
        List<Book> listBooks = bookRepository.findAll();
        assertEquals(2, listBooks.size());

        //CleanUp
        bookRepository.deleteById(id1);
        bookRepository.deleteById(id2);
    }

    @Test
    public void testBookRepositoryDeleteById() {
        //Given
        Book Book1 = new Book( "Jan", "Nowak", LocalDate.of(2020, 1, 8));
        Book Book2 = new Book( "Anna", "Nowak", LocalDate.of(2021, 1, 13));

        //When
        bookRepository.save(Book1);
        bookRepository.save(Book2);

        //Then
        Long id1 = Book1.getId();
        Long id2 = Book2.getId();
        bookRepository.deleteById(id2);
        assertEquals(1, bookRepository.findAll().size());

        //CleanUp
        bookRepository.deleteById(id1);
    }
}