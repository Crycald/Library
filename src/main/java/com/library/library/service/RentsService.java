package com.library.library.service;

import com.library.library.domain.Books;
import com.library.library.domain.Readers;
import com.library.library.domain.Rents;
import com.library.library.domain.RentsDto;
import com.library.library.mapper.RentsMapper;
import com.library.library.repository.BooksRepository;
import com.library.library.repository.ReadersRepository;
import com.library.library.repository.RentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentsService {
    private final RentsRepository repository;
    private final RentsMapper mapper;
    private final ReadersRepository readersRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public RentsService(RentsRepository repository, RentsMapper mapper,
                        ReadersRepository readersRepository,BooksRepository booksRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.readersRepository = readersRepository;
        this.booksRepository = booksRepository;
    }

    public List<RentsDto> getRents() {
        return mapper.mapToRentsDtoList(repository.findAll());
    }

    public RentsDto getRent(final Long id) {
        Optional<Rents> rents = repository.findById(id);
        return mapper.mapToRentsDto(rents.orElse(null));
    }

    public void deleteRent(final Long id) {
        repository.deleteById(id);
    }

    public RentsDto createRent(final RentsDto rentsDto) {
        Readers readers = readersRepository.findById(rentsDto.getReaderId()).orElse(null);
        Books books = booksRepository.findById(rentsDto.getBookId()).orElse(null);
        Rents rents = mapper.mapToRents(rentsDto, readers, books);
        rentsDto.setRentId(null);
        return mapper.mapToRentsDto(repository.save(rents));
    }

    public RentsDto updateRent(final RentsDto rentsDto) {
        Readers readers = readersRepository.findById(rentsDto.getReaderId()).orElse(null);
        Books books = booksRepository.findById(rentsDto.getBookId()).orElse(null);
        return mapper.mapToRentsDto(repository.save(mapper.mapToRents(rentsDto, readers, books)));
    }
}
