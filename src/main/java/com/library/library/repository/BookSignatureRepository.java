package com.library.library.repository;

import com.library.library.domain.BookSignature;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookSignatureRepository extends CrudRepository<BookSignature, Long> {
    @Override
    List<BookSignature> findAll();

    @Override
    BookSignature save(BookSignature bookSignature);

    @Override
    Optional<BookSignature> findById(Long id);

    @Override
    void deleteById(Long id);
}
