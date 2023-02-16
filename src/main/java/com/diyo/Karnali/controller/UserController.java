package com.diyo.Karnali.controller;

import com.diyo.Karnali.Exception.UserNotFoundException;
import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;

//    @PostMapping("/create")
//    public User createUser(@RequestBody User user){
//
//        return  userRepo.save(user);
//
//    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){

        User usr =  userRepo.save(user);

        return  new ResponseEntity<>(usr, HttpStatus.CREATED);

    }
    @PostMapping("/getall")
    public ResponseEntity<User> getAllUsers(@RequestBody @Valid User user){
        User userall = (User) userRepo.findAll();
        return new ResponseEntity<>(userall,HttpStatus.CREATED);
    }
//    @GetMapping("/all")
//    public List<User> getAllUsers(){
//        return userRepo.findAll();
//    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws UserNotFoundException {
        User user ;
        try{
            user =  userRepo.findById(id).get();
        } catch(NoSuchElementException ex){
            throw new UserNotFoundException("User Not Found With ID number: "+id);
        }
        return user;
    }
}
