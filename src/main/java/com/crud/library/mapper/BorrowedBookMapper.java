package com.crud.library.mapper;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.BorrowedBookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowedBookMapper {

    public BorrowedBookDto mapToBorrowedBookDto (BorrowedBook borrowedBook) {
        return new BorrowedBookDto(
                borrowedBook.getId(),
                borrowedBook.getBookId(),
                borrowedBook.getReaderId(),
                borrowedBook.getHiredDate(),
                borrowedBook.getRedelivering()
        );
    }

    public BorrowedBook mapToBorrowedBook (BorrowedBookDto borrowedBookDto) {
        return new BorrowedBook(
                borrowedBookDto.getId(),
                borrowedBookDto.getBookId(),
                borrowedBookDto.getReaderId(),
                borrowedBookDto.getHiredDate(),
                borrowedBookDto.getRedelivering()
        );
    }

    public List<BorrowedBookDto> mapToListDto (List<BorrowedBook> borrowedBooks) {
        return borrowedBooks.stream()
                .map(t -> new BorrowedBookDto(t.getId(), t.getBookId(), t.getReaderId(), t.getHiredDate(), t.getRedelivering()))
                .collect(Collectors.toList());
    }

}
