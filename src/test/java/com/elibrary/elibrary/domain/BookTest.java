package com.elibrary.elibrary.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.DecodedJWT;

public class BookTest {
	private Book book;
	private String role;
	private String username;
	private String name ="Onurcem";
	private String title = "Onurcemin Sucu Ne?";
	private String description = "Onurcemin tuvalet sorunları";
	private int pageCount = 333;
	private int status = 1;
	private Author author =new Author("Erkan","Zileli");
	private int	downloadCount = 3322;
	private int	likeCount = 1212;
	private User user = new User("admin2","password","firstname","lastname","email",
			"type",1,false);
	private BookCategory bookCategory = new BookCategory("Drama");

	@Before
	public void beforeEach(){
			book= new Book(name, title, description, pageCount, status, author, downloadCount, likeCount, user, bookCategory);
			String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJlZGl0b3IiLCJleHAiOjE1NDQ0NzQxNTB9."
					+ "Gjjj3NeBpD62v0yOdUG_u0iyAfH5QIDyFuxqpkQLclCxu7FpeUZztp_q-vwJt3t7lSVlTQXSj7TWhSeSU83UrQ";

			DecodedJWT jwt = JWT.decode(token);
		    role = jwt.getClaim("role").asString();
		    username = jwt.getClaim("sub").asString();
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
		 Author newAuthor =new Author("Onur","Yartaşı");
		 User newUser = new User("username2","password2","firstname","lastname","email",
					"type",1,false);
		BookCategory newBookCategory = new BookCategory("Drama");
	    if(role.equals("editor") || username.equals(book.getUser().getUsername())) {
	    	 book.updateBook(newname,newTitle,newDescription,newAuthor,newUser,newBookCategory);
	    }

	    assertEquals(newname, book.getName());
	    assertEquals(newTitle, book.getTitle());
	    assertEquals(newDescription, book.getDescription());
	    assertEquals(newAuthor, book.getAuthor());
	    assertEquals(newUser, book.getUser());
	    assertEquals(newBookCategory,book.getCategory());

		
		
	
		
	}
	
	
	
	
	
	
	


}