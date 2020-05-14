package com.library.library.mapper;

import com.library.library.domain.Readers;
import com.library.library.domain.ReadersDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReadersMapper {
    public Readers mapToReaders(final ReadersDto readersDto) {
        return Readers.builder()
                .id(readersDto.getId())
                .firstname(readersDto.getFirstname())
                .lastname(readersDto.getLastname())
                .createdAcc(readersDto.getCreatedAcc())
                .build();
    }

    public ReadersDto mapToReaderssDto(final Readers readers) {
        ReadersDto.builder()
                .id(readers.getId())
                .build();

        return new ReadersDto(
                readers.getId(),
                readers.getFirstname(),
                readers.getLastname(),
                readers.getCreatedAcc()
        );
    }

    public List<ReadersDto> mapToReadersDtoList(final List<Readers> readersList) {
        return readersList
                .stream()
                .map(this::mapToReaderssDto)
                .collect(Collectors.toList());
    }
}
