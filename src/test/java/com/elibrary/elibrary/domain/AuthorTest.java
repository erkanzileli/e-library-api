package com.elibrary.elibrary.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

	private Author author;
	private final String FIRST_NAME = "Azra";
	private final String LAST_NAME = "Kohen";

	/*
	 * 
	 */

//	@BeforeClass
//	public void beforeAll() {
//
//	}
//
//	@AfterClass
//	public void afterAll() {
//
//	}

	@Before
	public void beforeEach() {
		author = new Author(FIRST_NAME, LAST_NAME);
	}

	@After
	public void afterEach() {
		author = null;
	}

	@Test
	public void testGetId() {
		assertEquals(author.getId(), 0);
	}

	@Test
	public void testGetFirstName() {
		assertEquals(author.getFirstName(), FIRST_NAME);
	}

	@Test
	public void testGetLastName() {
		assertEquals(author.getLastName(), LAST_NAME);
	}

	@Test
	public void testSetId() {
		long id = 1;
		author.setId(id);
		assertEquals(author.getId(), id);
	}

	@Test
	public void testSetFirstName() {
		String firstName = "Akilah";
		author.setFirstName(firstName);
		assertEquals(author.getFirstName(), firstName);
	}

	@Test
	public void testSetLastName() {
		String lastName = "Akilah";
		author.setLastName(lastName);
		assertEquals(author.getLastName(), lastName);
	}
}
