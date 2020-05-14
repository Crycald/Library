package com.library.library.service;

import com.library.library.domain.BookSignature;
import com.library.library.domain.BookSignatureDto;
import com.library.library.mapper.BookSignatureMapper;
import com.library.library.repository.BookSignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookSignatureService {
    private final BookSignatureMapper mapper;
    private final BookSignatureRepository repository;

    @Autowired
    public BookSignatureService(BookSignatureMapper mapper, BookSignatureRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<BookSignatureDto> getBookSignatures() {
        return mapper.mapToBookSignatureDtoList(repository.findAll());
    }

    public BookSignatureDto getBookSignatureById(final Long id) {
        Optional<BookSignature> signature = repository.findById(id);
        return mapper.mapToBookSignatureDto(signature.orElse(null));
    }

    public void deleteBookSignatureById(final Long id) {
        repository.deleteById(id);
    }

    public BookSignatureDto createBookSignature(final BookSignatureDto bookSignatureDto) {
        BookSignature signature = mapper.mapToBookSignature(bookSignatureDto);
        bookSignatureDto.setId(null);
        return mapper.mapToBookSignatureDto(repository.save(mapper.mapToBookSignature(bookSignatureDto)));
    }

    public BookSignatureDto updateBookSignature(final BookSignatureDto bookSignatureDto) {
        repository.findById(bookSignatureDto.getId()).orElse(null);
        return mapper.mapToBookSignatureDto(repository.save(mapper.mapToBookSignature(bookSignatureDto)));
    }
}
