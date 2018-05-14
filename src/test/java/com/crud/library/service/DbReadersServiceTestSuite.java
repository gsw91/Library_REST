package com.crud.library.service;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbReadersServiceTestSuite {

    @InjectMocks
    private DbReadersService service;

    @Mock
    private ReaderRepository repository;

    @Test
    public void shouldFetchAllReaders() {
        //Given
        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader(1L, "Grzegorz", "Wojcik", new Date(20180514)));
        readers.add(new Reader(2L, "John", "Kovalsky", new Date(20180514)));
        when(repository.findAll()).thenReturn(readers);
        //When
        List<Reader> retrievedReaders = service.findAll();
        //Then
        assertSame(readers, retrievedReaders);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void shouldAddNewReader() {
        //Given
        Reader reader = new Reader(2L, "John", "Kovalsky", new Date(20180514));
        when(repository.save(any(Reader.class))).thenReturn(reader);
        //When
        Reader savedReader = service.save(reader);
        //Then
        assertSame(reader, savedReader);
        verify(repository, times(1)).save(reader);
    }
}