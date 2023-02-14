package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.exception.UserNotFoundException;
import com.diyo.Karnali.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;




    @PostMapping("/create")
    public ResponseEntity<User> createNewUser(@RequestBody @Valid User user){
       User usr =  userRepo.save(user);

        return  new ResponseEntity<>(usr, HttpStatus.CREATED);

    }

    @PostMapping("/create")
    public User createUser(@RequestBody @Valid User user){


        return  userRepo.save(user);

    }

    @GetMapping("/all")
    public List<User> getAllUsers(){

        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws UserNotFoundException{

        User user ;

        try{
            user =  userRepo.findById(id).get();
        } catch(NoSuchElementException ex){
            throw new UserNotFoundException("user not found with id "+id);
        }

        return user;
    }
}
