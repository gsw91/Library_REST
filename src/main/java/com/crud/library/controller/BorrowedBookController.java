package com.crud.library.controller;

import com.crud.library.domain.BorrowedBookDto;
import com.crud.library.exceptions.NoSuchBookException;
import com.crud.library.mapper.BorrowedBookMapper;
import com.crud.library.service.DbBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/borrowed/")
@CrossOrigin(origins = "*")
public class BorrowedBookController {

    @Autowired
    private DbBorrowedBookService service;

    @Autowired
    private BooksController booksController;

    @Autowired
    private BorrowedBookMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowedBooks")
    public List<BorrowedBookDto> getBorrowedBooks() {
        return mapper.mapToListDto(service.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "borrow", consumes = APPLICATION_JSON_VALUE)
    public void borrowBook(@RequestBody BorrowedBookDto borrowedBookDto) throws NoSuchBookException {
        if (booksController.getBook(borrowedBookDto.getBookId()).getStatus().equals("available")) {
            try {
                booksController.updateBook(borrowedBookDto.getBookId(), "unavailable");
            } catch (NoSuchBookException e) {
            }
            service.save(mapper.mapToBorrowedBook(borrowedBookDto));
        } else {
            System.out.println("This book is unavailable");
            throw new NoSuchBookException("This book is unavailable");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "redelivering")
    public void updateRedelivery(@RequestParam Long id) throws NoSuchBookException {
        if(service.findById(id).isPresent()) {
            Long bookId = getBook(id).get().getBookId();
            service.delete(id);
            try {
                booksController.updateBook(bookId, "available");
            } catch (NoSuchBookException e) {
                System.out.println(e.getMessage() + e);
            }
        } else {
            throw new NoSuchBookException("There is no such borrowed book with this ID");
        }
    }

    private Optional<BorrowedBookDto> getBook(Long id) {
        return ofNullable(mapper.mapToBorrowedBookDto(service.findById(id).orElse(null)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateIfStolen")
    public void updateBorrow(@RequestParam Long id, @RequestParam Boolean isPaid) throws NoSuchBookException {
        if(service.findById(id).isPresent()) {
            BorrowedBookDto bookDto = mapper.mapToBorrowedBookDto(service.findById(id).orElse(null));
            if (isPaid) {
                try {
                    updateRedelivery(id);
                } catch (NoSuchBookException e) {
                    System.out.println(e.getMessage() + e);
                }
            } else {
                service.save(mapper.mapToBorrowedBook(new BorrowedBookDto(
                                id,
                                bookDto.getBookId(),
                                bookDto.getReaderId(),
                                bookDto.getHiredDate(),
                                "stolen - to pay by reader: " + bookDto.getReaderId()
                        ))
                );
            }
        } else {
            throw new NoSuchBookException("There is no such borrowed book with this ID");
        }
    }

}
