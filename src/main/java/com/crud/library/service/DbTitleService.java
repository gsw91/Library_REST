package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbTitleService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    public Title addTitle(Title title) {
        return titleRepository.save(title);
    }

}
