package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderMapperTestSuite {

    @Autowired
    private ReaderMapper mapper;

    @Test
    public void testMapToReaderDto() {
        //Given
        Reader reader = new Reader(1L, "John", "Kovalsky", new Date(20180514));
        //When
        ReaderDto readerDto = mapper.mapToReaderDto(reader);
        //Then
        assertSame(reader.getFirstname(), readerDto.getFirstname());
        assertSame(reader.getJoined(), readerDto.getJoined());
        assertSame(reader.getReaderId(), readerDto.getReaderId());
    }

    @Test
    public void testMapToReader() {
        //Given
        ReaderDto readerDto = new ReaderDto(1L, "John", "Kovalsky", new Date(20180514));
        //When
        Reader reader = mapper.mapToReader(readerDto);
        //Then
        assertSame(reader.getFirstname(), readerDto.getFirstname());
        assertSame(reader.getJoined(), readerDto.getJoined());
        assertSame(reader.getReaderId(), readerDto.getReaderId());
    }

    @Test
    public void mapToListDto() {
        //Given
        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader(1L, "John", "Kovalsky", new Date(20180514)));
        readers.add(new Reader(2L, "David", "Kovalsky", new Date(20180514)));
        //When
        List<ReaderDto> readerDtos = mapper.mapToListDto(readers);
        //Then
        assertEquals(readers.size(), readerDtos.size());
        assertNotSame(readers.get(1), readerDtos.get(1));
    }
}