package com.crud.library.repository;

import com.crud.library.domain.BorrowedBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowedBookRepository extends CrudRepository <BorrowedBook, Long> {

    @Override
    List<BorrowedBook> findAll();

    @Override
    Optional<BorrowedBook> findById(Long id);

    @Override
    BorrowedBook save (BorrowedBook borrowedBook);

    @Override
    void deleteById(Long id);

}
