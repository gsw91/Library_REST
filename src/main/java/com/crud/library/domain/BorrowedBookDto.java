package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BorrowedBookDto {
    private Long id;
    private Long bookId;
    private Long readerId;
    private Date hiredDate;
    private String redelivering;

}