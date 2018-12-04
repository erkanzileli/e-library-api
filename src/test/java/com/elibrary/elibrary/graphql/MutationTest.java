package com.elibrary.elibrary.graphql;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.elibrary.elibrary.domain.User;
import com.elibrary.elibrary.repository.AuthorRepository;
import com.elibrary.elibrary.repository.UserRepository;

public class MutationTest {
    private User user;
    private UserRepository userRepository;
    private AuthorRepository authorRepository;
    private Mutation mutation;
    private String username="username";
    private String password="password";
    private String firstName="abdül";
    private String lastName="kadir";
    private String email="abdül.com";
    private String type="yakisikli ";
    private int status=1;
    private boolean isRequested=false;

    @Before
    public void beforeEach(){
    	
    	mutation = new Mutation();
    	
        user = new User(username,password,firstName,lastName,email,type,status,isRequested);
        
        
    }
    @After
    public void afterEach(){
        userRepository.delete(user);
    }
    
    @Test
    public void testTransformUser() {
    	
    	boolean oldIsRequest = user.isRequested();
        boolean newIsRequested = mutation.transformUser(id);
        assertNotEquals(oldIsRequest,newIsRequested);
    }
	
	

}
