package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorrowedBookDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("book_id")
    private Long bookId;

    @JsonProperty("reader_id")
    private Long readerId;

    @JsonProperty("hired_date")
    private Date hiredDate;

    @JsonProperty("redelivering")
    private String redelivering;

}