package com.elibrary.elibrary.graphql;

import java.util.List;
import java.util.stream.Collectors;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.domain.BookCategory;
import com.elibrary.elibrary.domain.User;

import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.BookCategoryRepository;
import com.elibrary.elibrary.repository.BookRepository;
import com.elibrary.elibrary.repository.UserRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private BookCategoryRepository bookCategoryRepository;
    private UserRepository userRepository;

    public Mutation() {

    }

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository,
                    BookCategoryRepository bookCategoryRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    /*
     * Author
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
            List<Book> books = bookRepository.findAll();
            books.forEach(book -> {
                if (book.getAuthor() != null && book.getAuthor().getId() == id) {
                    book.setAuthor(null);
                }
            });
            bookRepository.saveAll(books);
            Author author = authorRepository.findById(id).get();
            authorRepository.delete(author);
            return true;
        } catch (JpaObjectRetrievalFailureException e) {
            return false;
        }
    }

    /*
     * BookCategory
     */
    public BookCategory createBookCategory(String name) {
        try {
            return bookCategoryRepository.save(new BookCategory(name));
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    public BookCategory updateBookCategory(long id, String name) {
        BookCategory bookCategory = bookCategoryRepository.getOne(id);
        bookCategory.setName(name);
        return bookCategoryRepository.save(bookCategory);
    }

    public boolean deleteBookCategory(long id) {
        try {
            List<Book> books = bookRepository.findAll();
            books.forEach(book -> {
                if (book.getCategory() != null && book.getCategory().getId() == id) {
                    book.setCategory(null);
                }
            });
            bookRepository.saveAll(books);
            BookCategory bookCategory = bookCategoryRepository.findById(id).get();
            bookCategoryRepository.delete(bookCategory);
            return true;
        } catch (JpaObjectRetrievalFailureException e) {
            return false;
        }
    }

    /*
     * Book
     */
    public Book createBook(String name, String title, String description, int pageCount, String username, long authorId,
                           long categoryId) {
        Author author = authorRepository.findById(authorId).get();
        BookCategory bookCategory = bookCategoryRepository.findById(categoryId).get();
        User user = userRepository.findByUsername(username);
        return bookRepository
                .save(new Book(name, title, description, pageCount, 1, author, 0, 0, user, bookCategory, null));
    }

    public Book updateBook(long id, String token, String name, String title, String description, int pageCount,
                           long authorId, long userId, long categoryId) {
        Book book = bookRepository.findById(id).get();
        boolean result = book.updateBook(token, name, title, description, pageCount,
                authorRepository.findById(authorId).get(), userRepository.findById(userId).get(),
                bookCategoryRepository.findById(categoryId).get());
        System.out.println(result);
        System.out.println(result);
        System.out.println(result);
        return bookRepository.save(book);
    }

    public boolean deleteBook(long id, String token) {
        try {
            Book book = bookRepository.findById(id).get();
            boolean result = book.deleteBook(token);
            if (result) {
                bookRepository.delete(book);
            }
            return true;
        } catch (JpaObjectRetrievalFailureException e) {
            return false;
        }
    }

    /*
     * User
     */
    public boolean transformUser(long id) {
        User user = userRepository.getOne(id);
        return user.transformUser();
    }

    public User changeUserType(long id, String type) {
        User user = userRepository.findById(id).get();
        user.setType(type);
        userRepository.save(user);
        return user;
    }

    public User updateUser(long id, String firstName, String lastName, String email) {
        User user = userRepository.findById(id).get();
        user.updateUser(firstName, lastName, email);
        userRepository.save(user);
        return user;
    }

    public boolean requestUser(String username) {
        User user = userRepository.findByUsername(username);
        if (!user.isRequested()) {
            user.setRequested(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public User userToEditor(long id) {
        User user = userRepository.findById(id).get();
        user.setType("editor");
        return userRepository.save(user);
    }

    public User changeUserStatus(String username, boolean status) {
        User user = userRepository.findByUsername(username);
        if (status) {
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        return userRepository.save(user);
    }
}
