package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.BookCategory;
import org.springframework.data.repository.CrudRepository;

public interface BookCategoryRepository extends CrudRepository<BookCategory, Long> {

}
