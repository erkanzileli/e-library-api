package com.elibrary.elibrary.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class BookTest {
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
			book= new Book(name, title, description, pageCount, status, author, downloadCount, likeCount, user, bookCategory);
			tokenEditor ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlZGl0b3IiLCJyb2xlIjoiZWRpdG9yIiwiZXhwIjoxNTQ0NjkzODI0fQ.MHjUPA6nuIj0RUp"
					+ "--zQwoDxYGsZGzaAYYIxMxcOHO-_6MUsKvdF7Qt3CXnLmw558nDrXie-8pCm_hRkcm7kHEA";
			tokenAdmin = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJhZG1pbiIsImV4cCI6MTU0NDY5Mzg4Nn0"
					+ ".RJcKKfSWiYvJKCQUfNkamVnnakmI2lWADDNrnPjGR-8B7lzJDo3ISnwekieZX5rIWtFsWua1x1-NAPdmf82MXw";
			tokenAnother = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbm90aGVyIiwicm9sZSI6ImVkaXRvciIsImV4cCI6MTU0NDY5NDA3M30."
					+ "sFRbFpRAuG5i0Qcoshv-44xwTJH4uIc_dt0v7iCHVF9A9CaHa0llBVB77jitHc5rDlwStjl5OKqKq4VmjH1hww";

	}
	@After
	public void afterEach(){
			book = null;
	}

	@Test
	public void testGetId() {
		Assert.assertEquals(book.getId(),0);
	}

	@Test
	public void testSetId() {
		long id=1;
		book.setId(id);
		Assert.assertEquals(book.getId(),id);
	}


	@Test
	public void testGetName() {
		Assert.assertEquals(book.getName(),name);
	}

	@Test
	public void testSetName(){
	String name="Onurcemkarakoc";
	book.setName(name);
	Assert.assertEquals(book.getName(),name);
	}

	@Test
	public void testGetTitle() {
		Assert.assertEquals(book.getTitle(),title);
	}


	@Test
	public void testSetTitle() {
		String title= "Baslik";
		book.setTitle(title);
		Assert.assertEquals(book.getTitle(),title);
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(book.getDescription(),description);
	}

	@Test
	public void testSetDescription() {
		String description="desc";
		book.setDescription(description);
		Assert.assertEquals(book.getDescription(),description);
	}
	
	@Test
	public void testGetFilePath() {
		assertEquals(filePath, book.getFilePath());
	}
	
	@Test
	public void testSetFilePath() {
		String newFilePath = "book/book1.png";
		book.setFilePath(newFilePath);
		assertEquals(newFilePath,book.getFilePath());
		
	}

	@Test
	public void testGetPageCount() {Assert.assertEquals(book.getPageCount(),pageCount);}


	@Test
	public void testSetPageCount() {
		int pageCount=330;
		book.setPageCount(pageCount);
		Assert.assertEquals(book.getPageCount(),pageCount);
	}

	@Test
	public void testGetStatus() { Assert.assertEquals(book.getStatus(),status); }

	@Test
	public void testSetStatus() {
		int status=0;
		book.setStatus(status);
		Assert.assertEquals(book.getStatus(),status);
	}

	@Test
	public void testGetAuthor() {
		Assert.assertEquals(book.getAuthor(),author);
	}

	@Test
	public void testSetAuthor() {
		Author author=new Author("fisrtname","lastname");
		book.setAuthor(author);
		Assert.assertEquals(book.getAuthor(),author);
	}

	@Test
	public void testGetDownloadCount() {
		Assert.assertEquals(book.getDownloadCount(),downloadCount);
	}

	@Test
	public void testSetDownloadCount() {
		int downloadCount=1000;
		book.setDownloadCount(downloadCount);
		Assert.assertEquals(book.getDownloadCount(),downloadCount);
	}

	@Test
	public void testGetLikeCount() {
		Assert.assertEquals(book.getLikeCount(),likeCount);
	}

	@Test
	public void testSetLikeCount() {
		int likeCount=222;
		book.setLikeCount(likeCount);
		Assert.assertEquals(book.getLikeCount(),likeCount);
	}

	@Test
	public void testGetUser() {
		Assert.assertEquals(book.getUser(),user);
	}

	@Test
	public void testSetUser() {
		User user=new User("un","pw","fn","ln","e","t",1,false);
		book.setUser(user);
		Assert.assertEquals(book.getUser(),user);
	}


	@Test
	public void testGetCategory() {
		Assert.assertEquals(book.getCategory(),bookCategory);
	}


	@Test
	public void testSetCategory() {
		BookCategory category=new BookCategory("Macera");
		book.setCategory(category);
		Assert.assertEquals(book.getCategory(),category);
	}
	@Test
	public void testUpdateBookWithManager() {
		String newname ="Horror Story";
		String newTitle = "This is a Horror Story";
		String newDescription = "Scary story";
		int newPageCount=309;
		Author newAuthor =new Author("Onur","Yartaşı");
		User newUser = new User("editor2","password2","firstname","lastname","email",
					"type",1,false);
		BookCategory newBookCategory = new BookCategory("Drama");
		boolean result = book.updateBook(tokenAdmin,newname,newTitle,newDescription,newPageCount,newAuthor,newUser,newBookCategory);
		assertTrue(result);
	    assertEquals(newname, book.getName());
	    assertEquals(newTitle, book.getTitle());
	    assertEquals(newDescription, book.getDescription());
	    assertEquals(newPageCount, book.getPageCount());
	    assertEquals(newAuthor, book.getAuthor());
	    
	    assertEquals(newUser, book.getUser());
	    assertEquals(newBookCategory,book.getCategory());	
		
	}
	
	@Test
	public void testUpdateBookWithSelfUser() {
		String newname ="Horror Story";
		String newTitle = "This is a Horror Story";
		String newDescription = "Scary story";
		int newPageCount=309;
		Author newAuthor =new Author("Onur","Yartaşı");
		User newUser = null;
		BookCategory newBookCategory = new BookCategory("Drama");
		boolean result = book.updateBook(tokenEditor,newname,newTitle,newDescription,newPageCount,newAuthor,newUser,newBookCategory);
		assertTrue(result);
		assertEquals(newname, book.getName());
		assertEquals(newTitle, book.getTitle());
		assertEquals(newDescription, book.getDescription());
		assertEquals(newDescription, book.getDescription());
		assertEquals(newAuthor, book.getAuthor());
		assertNotNull(book.getUser());
		assertEquals(newBookCategory,book.getCategory());	
		
	}
	@Test
	public void testUpdateBookWithAnotherUser() {
		String newname ="Horror Story";
		String newTitle = "This is a Horror Story";
		String newDescription = "Scary story";
		int newPageCount=309;
		Author newAuthor =new Author("Onur","Yartaşı");
		User newUser = null;
		BookCategory newBookCategory = new BookCategory("Drama");
		boolean result = book.updateBook(tokenAnother,newname,newTitle,newDescription,newPageCount,newAuthor,newUser,newBookCategory);
		assertFalse(result);	
		
	}
	@Test
	public void testDeleteBookWithManager() {
		boolean result = book.deleteBook(tokenAdmin);
		assertTrue(result);
	}
	@Test
	public void testDeleteBookWithSelfUser() {
		boolean result = book.deleteBook(tokenEditor);
		assertTrue(result);
	}
	@Test
	public void testDeleteBookWithAnotherUser() {
		boolean result = book.deleteBook(tokenAnother);
		assertFalse(result);
	}
	
	
	
	
	
	
	


}