package com.elibrary.elibrary.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.domain.BookCategory;
import com.elibrary.elibrary.domain.User;
import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.BookCategoryRepository;
import com.elibrary.elibrary.repository.BookRepository;
import com.elibrary.elibrary.repository.UserRepository;

public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private BookCategoryRepository bookCategoryRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public Query(AuthorRepository authorRepository, BookCategoryRepository bookCategoryRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    /*
    Author
     */
    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }
    public Author author(long id){
        return authorRepository.findById(id).get();
    }

    /*
    Book Category
     */
    public Iterable<BookCategory> bookCategories() {
        return bookCategoryRepository.findAll();
    }
    public BookCategory bookCategory(long id){
        return bookCategoryRepository.findById(id).get();
    }

    /*
    Book
     */
    public Iterable<Book> books() {
        return bookRepository.findAll();
    }
    public Book book(long id){
        return bookRepository.findById(id).get();
    }

    /*
    User
     */
    public Iterable<User> users() {
        return userRepository.findAll();
    }
    public User user(long id){
        return userRepository.findById(id).get();
    }
}
