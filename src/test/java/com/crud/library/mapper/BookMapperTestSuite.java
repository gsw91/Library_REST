package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTestSuite {

    @Autowired
    private BookMapper mapper;

    @Test
    public void testMapToBookDto() {
        //Given
        Book book = new Book(1L, 1L, "unavailable");
        //When
        BookDto mappedBookDto = mapper.mapToBookDto(book);
        //Then
        assertSame(book.getBookId(), mappedBookDto.getBookId());
        assertSame(book.getStatus(), mappedBookDto.getStatus());
        assertSame(book.getTitleId(), mappedBookDto.getTitleId());
    }

    @Test
    public void testMapToBook() {
        //Given
        BookDto bookDto = new BookDto(2L, 7L, "available");
        //When
        Book mappedBook = mapper.mapToBook(bookDto);
        //Then
        assertSame(bookDto.getBookId(), mappedBook.getBookId());
        assertSame(bookDto.getStatus(), mappedBook.getStatus());
        assertSame(bookDto.getTitleId(), mappedBook.getTitleId());
    }

    @Test
    public void testMapToListBookDto() {
        //Given
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1L, 1L, "unavailable"));
        bookList.add(new Book(2L, 7L, "available"));
        //When
        List<BookDto> mappedDtoList = mapper.mapToListBookDto(bookList);
        //Then
        assertEquals(bookList.size(), mappedDtoList.size());
    }
}