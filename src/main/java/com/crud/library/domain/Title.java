package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "titles")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long titleId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLISHED")
    private Long published;
}
