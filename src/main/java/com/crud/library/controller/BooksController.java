package com.crud.library.controller;

import com.crud.library.domain.BookDto;
import com.crud.library.exceptions.NoSuchBookException;
import com.crud.library.exceptions.NoSuchTitleException;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbBookService;
import com.crud.library.service.DbTitleService;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/v1/books/")
@RestController
@CrossOrigin(origins = "*")
public class BooksController {

    @Autowired
    private DbBookService service;

    @Autowired
    private DbTitleService titleService;

    @Autowired
    private BookMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return mapper.mapToListBookDto(service.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long id) {
        return mapper.mapToBookDto(service.findById(id).orElse(null));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook", consumes = APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto) throws NoSuchTitleException {
        if (titleService.findById(bookDto.getTitleId()).isPresent()) {
            service.addBook(mapper.mapToBook(bookDto));
        } else {
            throw new NoSuchTitleException("There isn't any title of this TITLE_ID, check database - entity TITLES");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long id) throws NoSuchBookException {
        if (service.findById(id).isPresent()) {
            service.deleteBook(id);
        } else {
            throw new NoSuchBookException("There is no such book with this ID");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public void updateBook(@RequestParam Long id, @RequestParam String status) throws NoSuchBookException {
        if (service.findById(id).isPresent()) {
            Long titleId = service.findById(id).get().getTitleId();
            BookDto bookDto = new BookDto(id, titleId, status);
            service.addBook(mapper.mapToBook(bookDto));
        } else {
            throw new NoSuchBookException("There is no such book with this ID");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "countAvailableBooks")
    public Long countAvailableBooks(@RequestParam Long titleId) {
        return service.countAvailableBooks(titleId);
    }

}
