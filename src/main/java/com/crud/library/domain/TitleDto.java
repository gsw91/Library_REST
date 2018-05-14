package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.sql.IntegerTypeDescriptor;

import java.sql.Date;
import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleDto {

    @JsonProperty("TITLE_ID")
    private Long titleId;

    @JsonProperty("TITLE")
    private String title;

    @JsonProperty("AUTHOR")
    private String author;

    @JsonProperty("PUBLISHED")
    private Long published;
}
