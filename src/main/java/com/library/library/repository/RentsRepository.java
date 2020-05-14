package com.library.library.repository;

import com.library.library.domain.Rents;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentsRepository extends CrudRepository<Rents, Long> {
    @Override
    List<Rents> findAll();

    @Override
    Rents save(Rents rents);

    @Override
    Optional<Rents> findById(Long id);

    @Override
    void deleteById(Long id);
}
