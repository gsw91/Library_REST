package com.crud.library.mapper;

import com.crud.library.domain.Title;
import com.crud.library.domain.TitleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleMapperTestSuite {

    @Autowired
    private TitleMapper mapper;

    @Test
    public void testMapToTitleDto() {
        //Given
        Title title = new Title(1L, "Testing title", "Test", 2018L);
        //When
        TitleDto titleDto = mapper.mapToTitleDto(title);
        //Then
        assertSame(title.getAuthor(), titleDto.getAuthor());
        assertSame(title.getPublished(), titleDto.getPublished());
        assertSame(title.getTitleId(), titleDto.getTitleId());
        assertSame(title.getTitle(), titleDto.getTitle());
    }

    @Test
    public void testMapToTitle() {
        //Given
        TitleDto titleDto = new TitleDto(1L, "Testing title", "Test", 2018L);
        //When
        Title title = mapper.mapToTitle(titleDto);
        //Then
        assertSame(titleDto.getAuthor(), title.getAuthor());
        assertSame(titleDto.getPublished(), title.getPublished());
        assertSame(titleDto.getTitleId(), title.getTitleId());
        assertSame(titleDto.getTitle(), title.getTitle());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<Title> titles = new ArrayList<>();
        titles.add(new Title(1L, "Testing title", "Test", 2018L));
        titles.add(new Title(2L, "Testing title 2", "Test", 2018L));
        //When
        List<TitleDto> titleDtos = mapper.mapToListDto(titles);
        //Then
        assertEquals(titles.size(), titleDtos.size());
        assertNotSame(titles.get(1), titleDtos.get(1));
    }
}