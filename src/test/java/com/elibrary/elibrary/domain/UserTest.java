package com.elibrary.elibrary.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;
    private String username="username";
    private String password="password";
    private String firstName="abdül";
    private String lastName="kadir";
    private String email="abdül.com";
    private String type="yakisikli ";
    private int status=1;
    private boolean isRequested=true;

    @Before
    public void beforeEach(){
        user=new User(username,password,firstName,lastName,email,type,status,isRequested);
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

    @Test
    public void getFirstName() {
        Assert.assertEquals(user.getFirstName(),firstName);
    }

    @Test
    public void setFirstName() {
        String firstName="a";
        user.setFirstName(firstName);
        Assert.assertEquals(user.getFirstName(),firstName);
    }

    @Test
    public void getLastName() {
    Assert.assertEquals(user.getLastName(),lastName);
    }

    @Test
    public void setLastName() {
        String lastName="b";
        user.setLastName(lastName);
        Assert.assertEquals(user.getLastName(),lastName);
    }

    @Test
    public void getEmail() {
        Assert.assertEquals(user.getEmail(),email);
    }

    @Test
    public void setEmail() {
        String email="e";
        user.setEmail(email);
        Assert.assertEquals(user.getEmail(),email);
    }

    @Test
    public void getType() {
        Assert.assertEquals(user.getType(),type);
    }

    @Test
    public void setType() {
        String type="t";
        user.setType(type);
        Assert.assertEquals(user.getType(),type);
    }

    @Test
    public void getStatus() {
        Assert.assertEquals(user.getStatus(),status);
    }

    @Test
    public void setStatus() {
        int status=1;
        user.setStatus(status);
        Assert.assertEquals(user.getStatus(),status);
    }

    @Test
    public void isRequested() {
        Assert.assertEquals(user.isRequested(),isRequested);
    }

    @Test
    public void setRequested() {
        boolean requested=false;
        user.setRequested(requested);
        Assert.assertEquals(user.isRequested(),requested);
    }







}
