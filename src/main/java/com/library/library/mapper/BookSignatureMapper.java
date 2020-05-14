package com.library.library.mapper;

import com.library.library.domain.BookSignature;
import com.library.library.domain.BookSignatureDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookSignatureMapper {
    public BookSignature mapToBookSignature(final BookSignatureDto bookSignatureDto) {
        return BookSignature.builder()
                .id(bookSignatureDto.getId())
                .title(bookSignatureDto.getTitle())
                .author(bookSignatureDto.getAuthor())
                .publicationDate(bookSignatureDto.getPublicationDate())
                .build();
    }

    public BookSignatureDto mapToBookSignatureDto(final BookSignature bookSignature) {
        BookSignatureDto.builder()
                .id(bookSignature.getId())
                .build();

        return new BookSignatureDto(
                bookSignature.getId(),
                bookSignature.getTitle(),
                bookSignature.getAuthor(),
                bookSignature.getPublicationDate()
        );
    }

    public List<BookSignatureDto> mapToBookSignatureDtoList(final List<BookSignature> bookSignatureList) {
        return bookSignatureList
                .stream()
                .map(this::mapToBookSignatureDto)
                .collect(Collectors.toList());
    }
}
