package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.domain.BookCategory;
import com.elibrary.elibrary.domain.User;

import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.BookCategoryRepository;
import com.elibrary.elibrary.repository.BookRepository;
import com.elibrary.elibrary.repository.UserRepository;


public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private BookCategoryRepository bookCategoryRepository;
    private UserRepository userRepository;

    public Mutation() {

    }

    public Mutation(AuthorRepository authorRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String firstName, String lastName) {
        return authorRepository.save(new Author(firstName, lastName));
    }

    public boolean transformUser(long id) {
        User user = userRepository.getOne(id);
        return user.transformUser();
    }

    public User updateUser(long id, String firstName, String lastName, String email) {
        User user = userRepository.getOne(id);
        user.updateUser(firstName, lastName, email);
        return user;

    }

    public Book createBookAndAuthorAndCategory(String name, String title, String description, int pageCount, long authorId, long userId, long categoryId) {
        Author author = authorRepository.findById(authorId).get();
        BookCategory bookCategory = bookCategoryRepository.findById(categoryId).get();
        User user = userRepository.findById(userId).get();
        return bookRepository.save(new Book(name, title,description,pageCount, 1, author, 0, 0 , user, bookCategory));
    }

}
