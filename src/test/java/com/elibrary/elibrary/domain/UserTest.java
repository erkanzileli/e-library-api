package com.elibrary.elibrary.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserTest {
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    private User user;
    private String username="username";
    private String password="password";
    private String firstName="abdül";
    private String lastName="kadir";
    private String email="abdül.com";
    private String type="Admin";
    private int status=1;
    private boolean isRequested=false;

    @Before
    public void beforeEach(){
        user=new User(username,password,firstName,lastName,email,type,status,isRequested);
    }
    @After
    public void afterEach(){
        user = null;
    }


    @Test
    public void testGetId() {
        Assert.assertEquals(user.getId(),0);
    }

    @Test
    public void testSetId() {
        long id=1;
        user.setId(id);
        Assert.assertEquals(user.getId(),id);
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals(user.getUsername(),username);
    }

    @Test
    public void testSetUsername() {
        String username="un";
        user.setUsername(username);
        Assert.assertEquals(user.getUsername(),username);
    }

    @Test
    public void testGetPassword() {
        Assert.assertEquals(user.getPassword(),password);
    }

    @Test
    public void testPassword() {
        String password="pw";
        user.setPassword(password);
        Assert.assertEquals(user.getPassword(),password);
    }

    @Test
    public void testChangePassword() {
        String password="pw";
    	bCryptPasswordEncoder = new BCryptPasswordEncoder();
    	user.changePassword(password);
    	boolean result = bCryptPasswordEncoder.matches(password, user.getPassword());
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFirstName() {
        Assert.assertEquals(user.getFirstName(),firstName);
    }

    @Test
    public void testSetFirstName() {
        String firstName="a";
        user.setFirstName(firstName);
        Assert.assertEquals(user.getFirstName(),firstName);
    }

    @Test
    public void testGetLastName() {
    Assert.assertEquals(user.getLastName(),lastName);
    }

    @Test
    public void testSetLastName() {
        String lastName="b";
        user.setLastName(lastName);
        Assert.assertEquals(user.getLastName(),lastName);
    }

    @Test
    public void testGetEmail() {
        Assert.assertEquals(user.getEmail(),email);
    }

    @Test
    public void testSetEmail() {
        String email="e";
        user.setEmail(email);
        Assert.assertEquals(user.getEmail(),email);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(user.getType(),type);
    }

    @Test
    public void testSetType() {
        String type="t";
        user.setType(type);
        Assert.assertEquals(user.getType(),type);
    }

    @Test
    public void testGetStatus() {
        Assert.assertEquals(user.getStatus(),status);
    }

    @Test
    public void testSetStatus() {
        int status=1;
        user.setStatus(status);
        Assert.assertEquals(user.getStatus(),status);
    }

    @Test
    public void testIsRequested() {
        Assert.assertEquals(user.isRequested(),isRequested);
    }

    @Test
    public void testSetRequested() {
        boolean requested=false;
        user.setRequested(requested);
        Assert.assertEquals(user.isRequested(),requested);
    }
    @Test
    public void testTransformUser() {
    	boolean oldIsRequested = user.isRequested();
    	boolean newIsRequested = user.transformUser();
        assertNotEquals(oldIsRequested,newIsRequested);
    }
    @Test
    public void testTransformUserCancelRequest() {
    	User user=new User("adnanfatih","adnanfatih123","Adnan","Fatih","adnan@fatih.com","editor",0,true);
    	boolean oldIsRequested = user.isRequested();
    	boolean newIsRequested = user.transformUser();
        assertNotEquals(oldIsRequested,newIsRequested);
    }
    
    @Test
    public void testUpdateUserIsEquals() {
    	String firstName = "FOO";
    	String lastName = "Bar";
        String email="foobar.com";
        user.updateUser(firstName,lastName,email);
    	assertEquals(firstName, user.getFirstName());
    	assertEquals(lastName, user.getLastName());
    	assertEquals(email, user.getEmail());

    }
    @Test
    public void testUpdateUserIsNotNull() {
    	String firstName = null;
    	String lastName = null;
        String email=null;
        user.updateUser(firstName,lastName,email);
    	assertNotNull(user.getFirstName());
    	assertNotNull(user.getLastName());
    	assertNotNull(user.getEmail());
    	
    }
    @Test
    public void testUpdateUserMixture() {
    	String firstName = "Foo";
    	String lastName = null;
        String email=null;
        user.updateUser(firstName,lastName,email);
    	assertEquals(firstName, user.getFirstName());
    	assertNotNull(user.getLastName());
    	assertNotNull(user.getEmail());
    	
    }
    
    
    






}
