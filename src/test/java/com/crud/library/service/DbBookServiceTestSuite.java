package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DbBookServiceTestSuite {

    @InjectMocks
    private DbBookService service;

    @Mock
    private BookRepository repository;

    @Test
    public void shouldFetchAllBooks() {
        //Given
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1L, 1L, "available"));
        when(repository.findAll()).thenReturn(bookList);
        //When
        List<Book> tasksRetrieved = service.findAll();
        //Then
        assertEquals(1, tasksRetrieved.size());
        assertNotEquals(2L, tasksRetrieved.get(0).getBookId().longValue());
    }

    @Test
    public void shouldFetchBook() {
        //Given
        Book book = new Book(1L, 1L, "available");
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(book));
        //When
        Optional<Book> testingBook = service.findById(1L);
        //Then
        assertTrue(testingBook.isPresent());
        assertSame(testingBook.get(), book);
    }

    @Test
    public void shouldSaveBook() {
        //Given
        Book book = new Book(1L, 1L, "available");
        when(repository.save(any(Book.class))).thenReturn(book);
        //When
        Book savedBook = service.addBook(book);
        //Then
        assertNotNull(savedBook);
        assertSame(savedBook, book);
    }

    @Test
    public void shouldDeleteBook() {
        //Given
        doNothing().when(repository).deleteById(1L);
        //When
        service.deleteBook(1L);
        //Then
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void shouldCountAvailableBooks() {
        //Given
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1L, 1L, "available"));
        bookList.add(new Book(2L, 1L, "available"));
        when(repository.findAll()).thenReturn(bookList);
        //When
        Long books = service.countAvailableBooks(1L);
        //Then
        assertEquals(2L, books.longValue());
    }

}