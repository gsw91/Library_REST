package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbTitleService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    public Optional<Title> findById(Long id) {
        return titleRepository.findById(id);
    }

    public Title addTitle(Title title) {
        return titleRepository.save(title);
    }

}
