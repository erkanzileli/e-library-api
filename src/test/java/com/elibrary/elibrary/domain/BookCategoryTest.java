package com.elibrary.elibrary.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookCategoryTest {
	
	private BookCategory category;
	private String name = "Ahmet";
	
	
	@Before
	public void beforeEach() {
		category = new BookCategory(name);
	}
	@After
	public void afterEach() {
		category = null;
	}
	
	@Test
	public void testGetId() {
		assertEquals(category.getId(), 0);
	}
	
	@Test
	public void testGetName() {
		assertEquals(category.getName(),name);
	}
	
	@Test
	public void testSetId() {
		long id = 1;
		category.setId(id);
		assertEquals(category.getId(), id);
	}
	
	@Test
	public void testSetName() {
		String name = "Fatma";
		category.setName(name);
		assertEquals(category.getName(), name);
	}
}

