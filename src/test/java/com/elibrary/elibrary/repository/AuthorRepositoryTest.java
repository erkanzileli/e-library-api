package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testCreateAuthor() {
        Author author = new Author("Azra", "Kohen");
        authorRepository.save(author);
        assertNotEquals(0, author.getId());
    }

    @Test
    public void testReadAuthorById() {
        Author author = new Author("Azra", "Kohen");
        authorRepository.save(author);
        Author _author = authorRepository.getOne(author.getId());
        assertNotNull(_author);
        assertEquals(_author.getFirstName(), author.getFirstName());
        assertEquals(_author.getLastName(), author.getLastName());
    }

    @Test
    public void testUpdateAuthorById() {
        Author author = new Author("Azra", "Kohen");
        authorRepository.save(author);
        String _firstName = "_Azra";
        String _lastName = "_Kohen";
        author.setFirstName(_firstName);
        author.setLastName(_lastName);
        authorRepository.save(author);
        assertEquals(_firstName, author.getFirstName());
        assertEquals(_lastName, author.getLastName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testDeleteAuthor() {
        Author author = new Author("Azra", "Kohen");
        authorRepository.save(author);
        long id = author.getId();
        authorRepository.delete(author);
        //throws error
        authorRepository.getOne(id);
    }
}
