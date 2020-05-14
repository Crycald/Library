package com.library.library.service;

import com.library.library.domain.Readers;
import com.library.library.domain.ReadersDto;
import com.library.library.mapper.ReadersMapper;
import com.library.library.repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadersService {
    private final ReadersMapper mapper;
    private final ReadersRepository repository;

    @Autowired
    public ReadersService(ReadersMapper mapper, ReadersRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<ReadersDto> getReaders() {
        return mapper.mapToReadersDtoList(repository.findAll());
    }

    public ReadersDto getReader(final Long id) {
        Optional<Readers> readers = repository.findById(id);
        return mapper.mapToReaderssDto(readers.orElse(null));
    }

    public void deleteReader(Long id) {
        repository.deleteById(id);
    }

    public ReadersDto createReader(final ReadersDto readersDto) {
        Readers readers = mapper.mapToReaders(readersDto);
        readersDto.setId(null);
        return mapper.mapToReaderssDto(repository.save(readers));
    }

    public  ReadersDto updateReader(final ReadersDto readersDto) {
        repository.findById(readersDto.getId()).orElse(null);
        return mapper.mapToReaderssDto(repository.save(mapper.mapToReaders(readersDto)));
    }
}
