package com.elibrary.elibrary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;



@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String title;

	private String description;

	private int pageCount;

	private int status;

	@ManyToOne
	@JoinColumn(name = "authorId")
	private Author author;

	private int downloadCount;

	private int likeCount;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private BookCategory category;

	public Book(String name, String title, String description, int pageCount, int status, Author author,
			int downloadCount, int likeCount, User user, BookCategory category) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.pageCount = pageCount;
		this.status = status;
		this.author = author;
		this.downloadCount = downloadCount;
		this.likeCount = likeCount;
		this.user = user;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public boolean updateBook(String token,String name,String title,String description,Author author,User user,BookCategory bookCategory) {
		DecodedJWT jwt = JWT.decode(token);
	    String role = jwt.getClaim("role").asString();
	    String username = jwt.getClaim("sub").asString();
	    if(role.equals("admin")) {
			this.setName(name);
			this.setTitle(title);
			this.setDescription(description);
			this.setAuthor(author);
			this.setUser(user);
			this.setCategory(bookCategory);
			return true;
	    }else if (username.equals(this.getUser().getUsername())) {
			this.setName(name);
			this.setTitle(title);
			this.setDescription(description);
			this.setAuthor(author);
			this.setCategory(bookCategory);
			return true;
	    }
		return false;
	}

	
}
