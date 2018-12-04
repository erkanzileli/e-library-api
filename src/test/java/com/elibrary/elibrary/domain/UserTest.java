package com.elibrary.elibrary.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;
    private String username="username";
    private String password="password";

    @Before
    public void beforeEach(){
        user=new User(username,password);
    }
    @After
    public void afterEach(){
        user = null;
    }


    @Test
    public void getId() {
        Assert.assertEquals(user.getId(),0);
    }

    @Test
    public void setId() {
        long id=1;
        user.setId(id);
        Assert.assertEquals(user.getId(),id);
    }

    @Test
    public void getUsername() {
        Assert.assertEquals(user.getUsername(),username);
    }

    @Test
    public void setUsername() {
        String username="un";
        user.setUsername(username);
        Assert.assertEquals(user.getUsername(),username);
    }

    @Test
    public void getPassword() {
        Assert.assertEquals(user.getPassword(),password);
    }

    @Test
    public void setPassword() {
        String password="pw";
        user.setPassword(password);
        Assert.assertEquals(user.getPassword(),password);
    }



}
