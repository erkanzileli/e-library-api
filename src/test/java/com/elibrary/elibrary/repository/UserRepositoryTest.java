package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.Author;
import com.elibrary.elibrary.domain.User;

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
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
    	User user=new User("adnanfatih","adnanfatih123","Adnan","Fatih","adnan@fatih.com","editor",0,false);
        userRepository.save(user);
        assertNotEquals(0, user.getId());
    }
    @Test
    public void testUpdateUser() {
    	String firstName = "Foo";
    	String lastName = "Bar";
        String email="foor@bar.com";
    	User user=new User("adnanfatih","adnanfatih123","Adnan","Fatih","adnan@fatih.com","editor",0,false);
        userRepository.save(user);
        User userdb = userRepository.getOne(user.getId());
        userdb.updateUser(firstName,lastName,email);
        userRepository.save(userdb);
        User userUpdated = userRepository.getOne(userdb.getId());
        
    	assertEquals(firstName, userUpdated.getFirstName());
    	assertEquals(lastName,userUpdated.getLastName());
    	assertEquals(email,userUpdated.getEmail());
    	
    	
    }
    @Test(expected = JpaObjectRetrievalFailureException.class )
    public void testDeleteUser() {
    	User user=new User("adnanfatih","adnanfatih123","Adnan","Fatih","adnan@fatih.com","editor",0,false);
        userRepository.save(user);
        User userdb = userRepository.getOne(user.getId());
        userRepository.delete(userdb);
        userRepository.getOne(userdb.getId());
    	
    }
    @Test
    public void testTransformUser() {
    	User user=new User("adnanfatih","adnanfatih123","Adnan","Fatih","adnan@fatih.com","editor",0,false);
    	boolean oldRequested = user.isRequested();
        userRepository.save(user);
        User userdb = userRepository.getOne(user.getId());
        userdb.transformUser();
        userRepository.save(userdb);
        User userdbTransofrmed = userRepository.getOne(user.getId());
        assertNotEquals(oldRequested,userdbTransofrmed.isRequested());
    	
    }

}
