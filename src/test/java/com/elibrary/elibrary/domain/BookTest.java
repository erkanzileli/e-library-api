package com.elibrary.elibrary.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Book book;

	private String name = "Onurcem";
	private String title = "Onurcemin Sucu Ne?";
	private String description = "Onurcemin tuvalet sorunları";
	private int pageCount = 333;
	private int status = 1;
	private Author author = new Author("Erkan", "Zileli");
	private int downloadCount = 3322;
	private int likeCount = 1212;
	private User user = new User("username", "password");
	private BookCategory bookCategory = new BookCategory("Drama");

	@Before
	public void beforeEach() {
		book = new Book(name, title, description, pageCount, status, author, downloadCount, likeCount, user,
				bookCategory);
	}

	@After
	public void afterEach() {
		book = null;
	}

	@Test
	public void testGetID() {
		assertEquals(book.getId(), 0);
	}

	@Test
	public void testSetID() {
		long id = 1;
		book.setId(id);
		assertEquals(book.getId(), id);
	}

	@Test
	public void testGetName() {
		assertEquals(book.getName(), name);
	}

	@Test
	public void testSetName() {
		String name = "ozge";
		book.setName(name);
		assertEquals(book.getName(), name);
	}

	@Test
	public void testGetTitle() {
		assertEquals(book.getTitle(), title);
	}

	@Test
	public void testSetTitle() {
		String title = "title";
		book.setTitle(title);
		assertEquals(book.getTitle(), title);
	}

	@Test
	public void getDescription() {
		assertEquals(book.getDescription(), description);
	}

	@Test
	public void setDescription() {
		String name = "fatma";
		book.setDescription(name);
		assertEquals(book.getDescription(), name);
	}

	@Test
	public void setPageCount() {
		int pageCount = 1;
		book.setPageCount(pageCount);
		assertEquals(book.getPageCount(), pageCount);
	}

	@Test
	public void getpageCount() {
		assertEquals(book.getPageCount(), pageCount);

	}

	@Test
	public void setStatus() {
		int _status = 1;
		book.setStatus(_status);
		assertEquals(book.getStatus(), _status);
	}

	@Test
	public void getStatus() {
		assertEquals(book.getStatus(), status);
	}
	
	@Test
	public void getAuthor() {
		assertEquals(book.getAuthor(), author);
	}
	
	@Test
	public void setAuthor() {
		Author aut = new Author("Stephan","Hawking");
		book.setAuthor(aut);
		assertEquals(book.getAuthor(), aut);
	}
	
	

}