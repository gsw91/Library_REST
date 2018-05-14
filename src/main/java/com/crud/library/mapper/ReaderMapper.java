package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public ReaderDto mapToReaderDto (Reader reader) {
        return new ReaderDto(
                reader.getReaderId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getJoined()
        );
    }

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getReaderId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getJoined()
        );
    }

    public List<ReaderDto> mapToListDto (List<Reader> readers) {
        return readers.stream()
                .map(t -> new ReaderDto(t.getReaderId(), t.getFirstname(), t.getLastname(), t.getJoined()))
                .collect(Collectors.toList());
    }

}
