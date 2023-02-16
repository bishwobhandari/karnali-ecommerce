package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.UserRepository;
import com.diyo.Karnali.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return  userService.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(@PathVariable User user){
        return userService.getUsers();
    }
    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long userId){
        return userService.deleteUser(userId);
    }

//    @PostMapping("/create")
//    public ResponseEntity<User> createNewUser(@RequestBody @Valid User user){
//        User usr =  userRepo.save(user);
//
//        return  new ResponseEntity<>(usr, HttpStatus.CREATED);
//
//    }

//    @PostMapping("/create")
//    public User createUser(@RequestBody User user){
//        public User createUser(@RequestBody @Valid User user){
//
//
//            return  userRepo.save(user);
//
//        }
//        @GetMapping("/all")
//        public List<User> getAllUsers(){
//
//            return userRepo.findAll();
//        }
//
//        @GetMapping("/{id}")
//        public User getUser(@PathVariable Long id) throws UserNotFoundException{
//
//            User user ;
//
//            try{
//                user =  userRepo.findById(id).get();
//            } catch(NoSuchElementException ex){
//                throw new UserNotFoundException("user not found with id "+id);
//            }
//
//            return user;
//        }
}
