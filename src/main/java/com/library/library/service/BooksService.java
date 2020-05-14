package com.library.library.service;

import com.library.library.domain.BookSignature;
import com.library.library.domain.Books;
import com.library.library.domain.BooksDto;
import com.library.library.mapper.BooksMapper;
import com.library.library.repository.BookSignatureRepository;
import com.library.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksMapper mapper;
    private final BooksRepository repository;
    private final BookSignatureRepository bookSignatureRepository;

    @Autowired
    public BooksService(BooksMapper mapper, BooksRepository repository, BookSignatureRepository bookSignatureRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.bookSignatureRepository = bookSignatureRepository;
    }

    public List<BooksDto> getBooks() {
        return mapper.mapToBooksDtoList(repository.findAll());
    }

    public BooksDto getBookById(Long id) {
        Optional<Books> books = repository.findById(id);
        return mapper.mapToBooksDto(books.orElse(null));
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public BooksDto createBook(final BooksDto booksDto) {
        BookSignature signature = bookSignatureRepository.findById(booksDto.getBookSignatureId()).orElse(null);
        Books books = mapper.mapToBooks(booksDto, signature);
        return mapper.mapToBooksDto(repository.save(books));
    }

    public BooksDto updateBook(final BooksDto booksDto) {
        repository.findById(booksDto.getId()).orElse(null);
        BookSignature signature = bookSignatureRepository.findById(booksDto.getBookSignatureId()).orElse(null);
        return mapper.mapToBooksDto(repository.save(mapper.mapToBooks(booksDto, signature)));
    }
}
