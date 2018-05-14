package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDto mapToBookDto(Book book){
        return new BookDto(
                book.getBookId(),
                book.getTitleId(),
                book.getStatus()
        );
    }

    public Book mapToBook(BookDto bookDto){
        return new Book(
                bookDto.getBookId(),
                bookDto.getTitleId(),
                bookDto.getStatus()
        );
    }

    public List<BookDto> mapToListBookDto (List<Book> books) {
        return books.stream()
                .map(t -> new BookDto(t.getBookId(), t.getTitleId(), t.getStatus()))
                .collect(Collectors.toList());

    }

}
