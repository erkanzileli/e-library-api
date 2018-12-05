package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.domain.User;
import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.BookRepository;
import com.elibrary.elibrary.repository.UserRepository;

public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public Query(AuthorRepository authorRepository,BookRepository bookRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;

    }

    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }
    public Iterable<Book> books() {
        return bookRepository.findAll();
    }
}
