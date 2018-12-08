package com.elibrary.elibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String name;
	
	public BookCategory(String name) {
		this.name = name; 
	}

	public BookCategory() {
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(long id) {
	this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
