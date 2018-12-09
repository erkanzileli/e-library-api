package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.BookCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class BookCategoryRepositoryTest {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Test
    public void testCreateBookCategory(){

        BookCategory bookCategory=new BookCategory("Macera");
        bookCategoryRepository.save(bookCategory);
        assertNotEquals(0,bookCategory.getId());
    }

    @Test
    public void testReadBookCategoryById(){
        BookCategory bookCategory=new BookCategory("Macera");
        bookCategoryRepository.save(bookCategory);
        BookCategory _bookCategory = bookCategoryRepository.getOne(bookCategory.getId());
        assertNotNull(_bookCategory);
        assertEquals(_bookCategory.getName(),bookCategory.getName());
    }

    @Test
    public void testUpdateBookCategoryById(){
        BookCategory bookCategory=new BookCategory("Macera");
        bookCategoryRepository.save(bookCategory);
        String _name="Aksiyon";
        bookCategory.setName(_name);
        bookCategoryRepository.save(bookCategory);
        assertEquals(_name,bookCategory.getName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public  void testDeleteBookCategory(){
        BookCategory bookCategory=new BookCategory("Macera");
        bookCategoryRepository.save(bookCategory);
        long id = bookCategory.getId();
        bookCategoryRepository.delete(bookCategory);
        bookCategoryRepository.getOne(id); // error

    }



}
