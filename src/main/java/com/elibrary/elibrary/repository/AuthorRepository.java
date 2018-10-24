package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
