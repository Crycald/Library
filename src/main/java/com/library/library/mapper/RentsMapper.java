package com.library.library.mapper;

import com.library.library.domain.Books;
import com.library.library.domain.Readers;
import com.library.library.domain.Rents;
import com.library.library.domain.RentsDto;

import java.util.List;
import java.util.stream.Collectors;

public class RentsMapper {
    public Rents mapToRents(final RentsDto rentsDto, final Readers readers, final Books books) {
        return Rents.builder()
                .rentId(rentsDto.getBookId())
                .readerId(readers)
                .bookId(books)
                .rentDate(rentsDto.getRentDate())
                .returnDate(rentsDto.getReturnDate())
                .build();
    }

    public RentsDto mapToRentsDto(final Rents rents) {
        RentsDto.builder()
                .readerId(rents.getReaderId().getId())
                .bookId(rents.getBookId().getId())
                .build();

        return new RentsDto(
                rents.getRentId(),
                rents.getReaderId().getId(),
                rents.getBookId().getId(),
                rents.getRentDate(),
                rents.getReturnDate()
        );
    }

    public List<RentsDto> mapToRentsDto(final List<Rents> rentsList) {
        return rentsList
                .stream()
                .map(this::mapToRentsDto)
                .collect(Collectors.toList());
    }
}
