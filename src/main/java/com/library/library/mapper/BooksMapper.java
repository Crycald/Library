package com.library.library.mapper;

import com.library.library.domain.BookSignature;
import com.library.library.domain.Books;
import com.library.library.domain.BooksDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BooksMapper {
    public Books mapToBooks(final BooksDto booksDto, final BookSignature bookSignature) {
        return Books.builder()
                .id(booksDto.getId())
                .bookSignatureId(bookSignature)
                .title(bookSignature)
                .status(booksDto.getStatus())
                .build();
    }

    public BooksDto mapToBooksDto(final Books books) {
        BooksDto.builder()
                .bookSignatureId(books.getBookSignatureId().getId())
                .build();

        return new BooksDto(
                books.getId(),
                books.getBookSignatureId().getId(),
                books.getTitle().getTitle(),
                books.getStatus()
        );
    }

    public List<BooksDto> mapToBooksDtoList(final List<Books> booksList) {
        return booksList
                .stream()
                .map(this::mapToBooksDto)
                .collect(Collectors.toList());
    }
}
