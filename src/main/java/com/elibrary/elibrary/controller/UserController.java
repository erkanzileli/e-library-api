package com.elibrary.elibrary.controller;

import com.elibrary.elibrary.domain.User;
import com.elibrary.elibrary.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> users(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public User signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setType("user");
        user.setStatus(1);
        return userRepository.save(user);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public boolean checkUserStatus(@RequestBody User _user) {
        User user = userRepository.findByUsername(_user.getUsername());
        return user.getStatus() == 1;
    }
}
