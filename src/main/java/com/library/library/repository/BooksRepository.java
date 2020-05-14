package com.library.library.repository;

import com.library.library.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {
    @Override
    List<Books> findAll();

    @Override
    Books save(Books books);

    @Override
    Optional<Books> findById(Long id);

    @Override
    void deleteById(Long id);
}
