package com.elibrary.elibrary;

import com.elibrary.elibrary.graphql.GraphQLErrorAdapter;
import com.elibrary.elibrary.graphql.Mutation;
import com.elibrary.elibrary.graphql.Query;
import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.UserRepository;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ELibraryApplication {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Query query(AuthorRepository authorRepository) {
        return new Query(authorRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository,UserRepository userRepository) {
        return new Mutation(authorRepository,userRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(ELibraryApplication.class, args);
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }
}
