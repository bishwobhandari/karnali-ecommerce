package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){

        return  userRepo.save(user);

    }

    @GetMapping("/all")
    public List<User> getAllUsers(){

        return userRepo.findAll();
    }
}
