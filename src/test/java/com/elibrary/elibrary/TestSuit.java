package com.elibrary.elibrary;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.elibrary.elibrary.domain.AuthorTest;
import com.elibrary.elibrary.domain.BookCategoryTest;
import com.elibrary.elibrary.domain.BookTest;
import com.elibrary.elibrary.domain.UserTest;
import com.elibrary.elibrary.repository.AuthorRepositoryTest;
import com.elibrary.elibrary.repository.BookCategoryRepositoryTest;
import com.elibrary.elibrary.repository.BookRepositoryTest;
import com.elibrary.elibrary.repository.UserRepositoryTest;


@RunWith(Suite.class)
@SuiteClasses({
	AuthorTest.class,
	BookCategoryTest.class,
	BookTest.class,
	UserTest.class,
	AuthorRepositoryTest.class,
	BookRepositoryTest.class,
	BookCategoryRepositoryTest.class,
	UserRepositoryTest.class
})

public class TestSuit {
	

}
