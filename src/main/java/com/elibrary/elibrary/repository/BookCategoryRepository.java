package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
