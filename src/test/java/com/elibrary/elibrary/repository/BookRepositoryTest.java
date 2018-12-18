package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.domain.BookCategory;
import com.elibrary.elibrary.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    
	private Book book;
	private String tokenEditor;
	private String tokenAdmin;
	private String tokenAnother;
	private String name ="Onurcem";
	private String title = "Onurcemin Sucu Ne?";
	private String description = "Onurcemin tuvalet sorunları";
	private String filePath = "book/book.pdf";
	private int pageCount = 333;
	private int status = 1;
	private Author author =new Author("Erkan","Zileli");
	private int	downloadCount = 3322;
	private int	likeCount = 1212;
	private User user = new User("editor","password","firstname","lastname","email",
			"type",1,false);
	private BookCategory bookCategory = new BookCategory("Drama");
    
	@Before
	public void beforeEach(){
			book = new Book(name, title, description, pageCount, status, author, downloadCount, likeCount, user, bookCategory, filePath);
			tokenEditor ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlZGl0b3IiLCJyb2xlIjoiZWRpdG9yIiwiZXhwIjoxNTQ0NjkzODI0fQ.MHjUPA6nuIj0RUp"
					+ "--zQwoDxYGsZGzaAYYIxMxcOHO-_6MUsKvdF7Qt3CXnLmw558nDrXie-8pCm_hRkcm7kHEA";
			tokenAdmin = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJhZG1pbiIsImV4cCI6MTU0NDY5Mzg4Nn0"
					+ ".RJcKKfSWiYvJKCQUfNkamVnnakmI2lWADDNrnPjGR-8B7lzJDo3ISnwekieZX5rIWtFsWua1x1-NAPdmf82MXw";
			tokenAnother = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbm90aGVyIiwicm9sZSI6ImVkaXRvciIsImV4cCI6MTU0NDY5NDA3M30."
					+ "sFRbFpRAuG5i0Qcoshv-44xwTJH4uIc_dt0v7iCHVF9A9CaHa0llBVB77jitHc5rDlwStjl5OKqKq4VmjH1hww";

	}

    @Test
    public void testCreateBook() {
        bookRepository.save(book);
        assertNotEquals(0, book.getId());
    }
	@Test
	public void testUpdateBookWithManager() {
		 String newname ="Horror Story";
		 String newTitle = "This is a Horror Story";
		 String newDescription = "Scary story";
		 int newPageCount=309;
		 Author newAuthor =new Author("Onur","Yartaşı");
		 bookRepository.save(book);

		 User newUser = new User("editor2","password2","firstname","lastname","email",
					"type",1,false);
		BookCategory newBookCategory = new BookCategory("Drama");
		
		Book bookdb = bookRepository.getOne(book.getId());
		boolean result = bookdb.updateBook(tokenAdmin,newname,newTitle,newDescription,newPageCount,newAuthor,newUser,newBookCategory);
		bookRepository.save(bookdb);
		Book bookdbUpdated = bookRepository.getOne(bookdb.getId());
		assertTrue(result);
	    assertEquals(newname, bookdbUpdated.getName());
	    assertEquals(newTitle, bookdbUpdated.getTitle());
	    assertEquals(newDescription, bookdbUpdated.getDescription());
	    assertEquals(newPageCount, bookdbUpdated.getPageCount());
	    assertEquals(newAuthor, bookdbUpdated.getAuthor());
	    assertEquals(newUser, bookdbUpdated.getUser());
	    assertEquals(newBookCategory,bookdbUpdated.getCategory());	
		
	}
	
	@Test
	public void testUpdateBookWithSelfUser() {
		 String newname ="Horror Story";
		 String newTitle = "This is a Horror Story";
		 String newDescription = "Scary story";
		 int newPageCount=309;
		 Author newAuthor =new Author("Onur","Yartaşı");
		 bookRepository.save(book);

		 User newUser = null;
		BookCategory newBookCategory = new BookCategory("Drama");
		
		Book bookdb = bookRepository.getOne(book.getId());
		boolean result = bookdb.updateBook(tokenEditor,newname,newTitle,newDescription,newPageCount,newAuthor,newUser,newBookCategory);
		bookRepository.save(bookdb);
		Book bookdbUpdated = bookRepository.getOne(bookdb.getId());
		assertTrue(result);
	    assertEquals(newname, bookdbUpdated.getName());
	    assertEquals(newTitle, bookdbUpdated.getTitle());
	    assertEquals(newDescription, bookdbUpdated.getDescription());
	    assertEquals(newPageCount, bookdbUpdated.getPageCount());
	    assertEquals(newAuthor, bookdbUpdated.getAuthor());
	    assertNotNull(bookdbUpdated.getUser());
	    assertEquals(newBookCategory,bookdbUpdated.getCategory());	
		
	}
    @Test(expected = JpaObjectRetrievalFailureException.class )
	public void testDeleteBookWithManager() {
		bookRepository.save(book);
		boolean result = book.deleteBook(tokenAdmin);
		if (result) {
			Book bookdb = bookRepository.getOne(book.getId());
			bookRepository.delete(bookdb);
			bookRepository.getOne(bookdb.getId());
		}
	}
    @Test(expected = JpaObjectRetrievalFailureException.class )
	public void testDeleteBookWithSelfUser() {
		bookRepository.save(book);
		boolean result = book.deleteBook(tokenEditor);
		if (result) {
			Book bookdb = bookRepository.getOne(book.getId());
			bookRepository.delete(bookdb);
			bookRepository.getOne(bookdb.getId());
		}
	}
}
	
