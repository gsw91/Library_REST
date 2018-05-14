package com.crud.library.domain;

import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.sql.IntegerTypeDescriptor;

import javax.persistence.*;
import java.sql.Date;
import java.time.Year;

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
