package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.repository.AuthorRepository;

public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }
}
