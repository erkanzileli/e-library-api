package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.repository.AuthorRepository;

public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String firstName, String lastName) {
        return authorRepository.save(new Author(firstName, lastName));
    }
}
