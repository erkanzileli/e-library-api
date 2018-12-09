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
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;


public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private BookCategoryRepository bookCategoryRepository;
    private UserRepository userRepository;

    public Mutation() {

    }

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookCategoryRepository= bookCategoryRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    /*
    Author
     */
    public Author createAuthor(String firstName, String lastName) {
        return authorRepository.save(new Author(firstName, lastName));
    }

    public Author updateAuthor(long id, String firstName, String lastName) {
        Author author = authorRepository.getOne(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }

    public boolean deleteAuthor(long id) {
        try {
            Author author = authorRepository.getOne(id);
            authorRepository.delete(author);
            return true;
        }catch (JpaObjectRetrievalFailureException e){
            return false;
        }
    }

    /*
    BookCategory
     */
    public BookCategory createBookCategory(String name) {
        return bookCategoryRepository.save(new BookCategory(name));
    }

    public BookCategory updateBookCategory(long id, String name) {
        BookCategory bookCategory = bookCategoryRepository.getOne(id);
        bookCategory.setName(name);
        return bookCategoryRepository.save(bookCategory);
    }

    public boolean deleteBookCategory(long id) {
        try {
            BookCategory bookCategory = bookCategoryRepository.getOne(id);
            bookCategoryRepository.delete(bookCategory);
            return true;
        }catch (JpaObjectRetrievalFailureException e){
            return false;
        }
    }

    /*
    Book
     */
    public Book createBook(String name, String title, String description, int pageCount, long userId, long authorId, long categoryId) {
        Author author = authorRepository.findById(authorId).get();
        BookCategory bookCategory = bookCategoryRepository.findById(categoryId).get();
        User user = userRepository.findById(userId).get();
        return bookRepository.save(new Book(name, title,description,pageCount, 1, author, 0, 0 , user, bookCategory));
    }

    public Book updateBook(long id,String token, String name, String title, String description, int pageCount, long authorId,long userId, long categoryId) {
        Book book = bookRepository.getOne(id);
        boolean result = book.updateBook(token,
        		name,
        		title,
        		description,
        		pageCount,
        		authorRepository.getOne(authorId),
        		userRepository.getOne(userId), 
        		bookCategoryRepository.getOne(categoryId));
        
        return bookRepository.save(book);
    }

    public boolean deleteBook(long id,String token) {
        try {
            Book book = bookRepository.getOne(id);
            boolean result = book.deleteBook(token);
            if (result) {bookRepository.delete(book);}
            return true;
        }catch (JpaObjectRetrievalFailureException e){
            return false;
        }
    }

    /*
    User
     */
    public boolean transformUser(long id) {
        User user = userRepository.getOne(id);
        return user.transformUser();
    }

    public User updateUser(long id, String firstName, String lastName, String email) {
        User user = userRepository.findById(id).get();
        user.updateUser(firstName, lastName, email);
        userRepository.save(user);
        return user;
    }
}
