package com.crud.library.service;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.repository.BorrowedBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DbBorrowedBookServiceTestSuite {

    @InjectMocks
    private DbBorrowedBookService service;

    @Mock
    private BorrowedBookRepository repository;

    @Test
    public void shouldFetchAllBorrowedBooks() {
        //Given
        List<BorrowedBook> borrowedBooks = new ArrayList<>();
        borrowedBooks.add(new BorrowedBook(1L, 2L, 3L, new Date(20180514), "no"));
        borrowedBooks.add(new BorrowedBook(2L, 1L, 1L, new Date(20180514), "no"));
        when(repository.findAll()).thenReturn(borrowedBooks);
        //When
        List<BorrowedBook> books = service.findAll();
        //Then
        assertSame(borrowedBooks, books);
        assertEquals(books.size(), 2);
    }

    @Test
    public void ShouldFindBorrowedBookById() {
        //Given
        BorrowedBook borrowedBook = new BorrowedBook(1L, 1L, 3L, new java.util.Date(20180514), "available");
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(borrowedBook));
        //When
        Optional<BorrowedBook> testingBook = service.findById(1L);
        //Then
        assertTrue(testingBook.isPresent());
        assertSame(testingBook.get(), borrowedBook);
    }

    @Test
    public void shouldAddNewBorrowedBook() {
        //Given
        BorrowedBook borrowedBook = new BorrowedBook(1L, 1L, 3L, new java.util.Date(20180514), "available");
        when(repository.save(any(BorrowedBook.class))).thenReturn(borrowedBook);
        //When
        BorrowedBook savedBook = service.save(borrowedBook);
        //Then
        assertNotNull(savedBook);
        assertSame(savedBook, borrowedBook);
    }

    @Test
    public void shouldReturnBorrowedBook() {
        //Given
        doNothing().when(repository).deleteById(1L);
        //When
        service.delete(1L);
        //Then
        verify(repository, times(1)).deleteById(1L);
    }
}