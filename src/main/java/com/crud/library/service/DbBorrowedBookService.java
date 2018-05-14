package com.crud.library.service;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.repository.BorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbBorrowedBookService {

    @Autowired
    private BorrowedBookRepository repository;

    public List<BorrowedBook> findAll(){
        return repository.findAll();
    }

    public Optional<BorrowedBook> findById (Long id) {
        return repository.findById(id);
    }

    public BorrowedBook save(final BorrowedBook book) {
        return repository.save(book);
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }

}
