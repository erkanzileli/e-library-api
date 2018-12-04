package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.User;
import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.UserRepository;

public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private UserRepository userRepository;
    public Query(AuthorRepository authorRepository,UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }
    public Iterable<User> users() {
        return userRepository.findAll();
    }
}
