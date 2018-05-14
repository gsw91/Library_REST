package com.crud.library.controller;

import com.crud.library.domain.Title;
import com.crud.library.domain.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.service.DbTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/titles/")
@CrossOrigin(origins = "*")
public class TitlesController {

    @Autowired
    private TitleMapper mapper;

    @Autowired
    private DbTitleService service;

    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> showAllTitles() {
        return mapper.mapToListDto(service.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "addTitle", consumes = APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        service.addTitle(mapper.mapToTitle(titleDto));
    }

}
