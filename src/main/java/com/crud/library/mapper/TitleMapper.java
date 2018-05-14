package com.crud.library.mapper;

import com.crud.library.domain.Title;
import com.crud.library.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getTitleId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublished()
        );
    }

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getTitleId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublished()
        );
    }

    public List<TitleDto> mapToListDto(List<Title> titles) {
        return titles.stream()
                .map(t -> new TitleDto(t.getTitleId(), t.getTitle(), t.getAuthor(), t.getPublished()))
                .collect(Collectors.toList());
    }

}
