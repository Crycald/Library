package com.library.library.repository;

import com.library.library.domain.Readers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReadersRepository extends CrudRepository<Readers, Long> {
    @Override
    List<Readers> findAll();

    @Override
    Readers save(Readers readers);

    @Override
    Optional<Readers> findById(Long id);

    @Override
    void deleteById(Long id);
}
