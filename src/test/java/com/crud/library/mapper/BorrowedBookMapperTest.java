package com.crud.library.mapper;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.BorrowedBookDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowedBookMapperTest {

    @Autowired
    private BorrowedBookMapper mapper;

    @Test
    public void testMapToBorrowedBookDto() {
        //Given
        BorrowedBook borrowedBook = new BorrowedBook(1L, 2L, 3L, new Date(20180514), "no");
        //When
        BorrowedBookDto borrowedBookDto = mapper.mapToBorrowedBookDto(borrowedBook);
        //Then
        assertSame(borrowedBook.getBookId(), borrowedBookDto.getBookId());
        assertSame(borrowedBook.getHiredDate(), borrowedBookDto.getHiredDate());
        assertSame(borrowedBook.getRedelivering(), borrowedBookDto.getRedelivering());
    }

    @Test
    public void testMapToBorrowedBook() {
        //Given
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto(1L, 2L, 3L, new Date(20180514), "no");
        //When
        BorrowedBook borrowedBook = mapper.mapToBorrowedBook(borrowedBookDto);
        //Then
        assertSame(borrowedBookDto.getBookId(), borrowedBook.getBookId());
        assertSame(borrowedBookDto.getHiredDate(), borrowedBook.getHiredDate());
        assertSame(borrowedBookDto.getRedelivering(), borrowedBook.getRedelivering());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<BorrowedBook> borrowedBooks = new ArrayList<>();
        borrowedBooks.add(new BorrowedBook(1L, 2L, 3L, new Date(20180514), "no"));
        borrowedBooks.add(new BorrowedBook(2L, 6L, 1L, new Date(20180514), "no"));
        //When
        List<BorrowedBookDto> borrowedBookDtos = mapper.mapToListDto(borrowedBooks);
        //Then
        assertEquals(borrowedBooks.size(), borrowedBookDtos.size());
        assertNotSame(borrowedBooks.get(1), borrowedBookDtos.get(1));
    }
}