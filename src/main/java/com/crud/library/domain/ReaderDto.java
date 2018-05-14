package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReaderDto {
    private Long readerId;
    private String firstname;
    private String lastname;
    private Date joined;
}
