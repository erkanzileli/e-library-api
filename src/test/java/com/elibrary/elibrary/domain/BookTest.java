package com.elibrary.elibrary.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Book book;
	private String name ="Onurcem";
	private String title = "Onurcemin Sucu Ne?";
	private String description = "Onurcemin tuvalet sorunları";
	private int pageCount = 333;
	private int status = 1;
	private Author author =new Author("Erkan","Zileli");
	private int	downloadCount = 3322;
	private int	likeCount = 1212;
	private User user = new User("username","password","firstname","lastname","email",
			"type",1,false);
	private BookCategory bookCategory = new BookCategory("Drama");

	@Before
	public void beforeEach(){
			book= new Book(name, title, description, pageCount, status, author, downloadCount, likeCount, user, bookCategory);
	}
	@After
	public void afterEach(){
			book = null;
	}

	@Test
	public void getId() {
		Assert.assertEquals(book.getId(),0);
	}

	@Test
	public void setId() {
		long id=1;
		book.setId(id);
		Assert.assertEquals(book.getId(),id);
	}


	@Test
	public void getName() {
		Assert.assertEquals(book.getName(),name);
	}

	@Test
	public void setName(){
	String name="Onurcemkarakoc";
	book.setName(name);
	Assert.assertEquals(book.getName(),name);
	}

	@Test
	public void getTitle() {
		Assert.assertEquals(book.getTitle(),title);
	}


	@Test
	public void setTitle() {
		String title= "Baslik";
		book.setTitle(title);
		Assert.assertEquals(book.getTitle(),title);
	}

	@Test
	public void getDescription() {
		Assert.assertEquals(book.getDescription(),description);
	}

	@Test
	public void setDescription() {
		String description="desc";
		book.setDescription(description);
		Assert.assertEquals(book.getDescription(),description);
	}

	@Test
	public void getPageCount() {Assert.assertEquals(book.getPageCount(),pageCount);}


	@Test
	public void setPageCount() {
		int pageCount=330;
		book.setPageCount(pageCount);
		Assert.assertEquals(book.getPageCount(),pageCount);
	}

	@Test
	public void getStatus() { Assert.assertEquals(book.getStatus(),status); }

	@Test
	public void setStatus() {
		int status=0;
		book.setStatus(status);
		Assert.assertEquals(book.getStatus(),status);
	}

	@Test
	public void getAuthor() {
		Assert.assertEquals(book.getAuthor(),author);
	}

	@Test
	public void setAuthor() {
		Author author=new Author("fisrtname","lastname");
		book.setAuthor(author);
		Assert.assertEquals(book.getAuthor(),author);
	}

	@Test
	public void getDownloadCount() {
		Assert.assertEquals(book.getDownloadCount(),downloadCount);
	}

	@Test
	public void setDownloadCount() {
		int downloadCount=1000;
		book.setDownloadCount(downloadCount);
		Assert.assertEquals(book.getDownloadCount(),downloadCount);
	}

	@Test
	public void getLikeCount() {
		Assert.assertEquals(book.getLikeCount(),likeCount);
	}

	@Test
	public void setLikeCount() {
		int likeCount=222;
		book.setLikeCount(likeCount);
		Assert.assertEquals(book.getLikeCount(),likeCount);
	}

	@Test
	public void getUser() {
		Assert.assertEquals(book.getUser(),user);
	}

	@Test
	public void setUser() {
		User user=new User("un","pw","fn","ln","e","t",1,false);
		book.setUser(user);
		Assert.assertEquals(book.getUser(),user);
	}


	@Test
	public void getCategory() {
		Assert.assertEquals(book.getCategory(),bookCategory);
	}


	@Test
	public void setCategory() {
		BookCategory category=new BookCategory("Macera");
		book.setCategory(category);
		Assert.assertEquals(book.getCategory(),category);
	}


}