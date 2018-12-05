package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
