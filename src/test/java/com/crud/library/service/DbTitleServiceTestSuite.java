package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbTitleServiceTestSuite {

    @InjectMocks
    private DbTitleService service;

    @Mock
    private TitleRepository repository;

    @Test
    public void shouldFetchAllTitles() {
        //Given
        List<Title> titles = new ArrayList<>();
        titles.add(new Title(1L, "Testing", "Test", 2018L));
        titles.add(new Title(3L, "Testing2", "Test", 2018L));
        when(repository.findAll()).thenReturn(titles);
        //When
        List<Title> testingTitles = service.findAll();
        //Then
        assertSame(testingTitles, titles);
        assertNotNull(titles.get(1));
        assertNotNull(testingTitles.get(1));
    }

    @Test
    public void shouldAddNewTitle() {
        //Given
        Title title = new Title(1L, "Testing", "Test", 2018L);
        when(repository.save(any(Title.class))).thenReturn(title);
        //When
        Title savedTitle = service.addTitle(title);
        //Then
        assertSame(title, savedTitle);
    }

}