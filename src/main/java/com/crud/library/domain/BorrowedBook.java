package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "borrowed_books")
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "reader_id")
    private Long readerId;

    @Column(name = "hired_date")
    private Date hiredDate;

    @Column(name = "redelivering")
    private String redelivering;

}
