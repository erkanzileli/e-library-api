package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.User;
import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.UserRepository;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public Mutation(AuthorRepository authorRepository,UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String firstName, String lastName) {
        return authorRepository.save(new Author(firstName, lastName));
    }

    public User transformUser(long id) {
        User user=userRepository.getOne(id);
        if(user.isRequested()){
            user.setRequested(false);
        }else{
            user.setRequested(true);
        }
        return userRepository.save(user);
    }


}
