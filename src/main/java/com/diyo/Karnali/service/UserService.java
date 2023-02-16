package com.diyo.Karnali.service;

import com.diyo.Karnali.entity.User;

import java.util.List;

public interface UserService {

    public User save(User user);

    public List<User> getUsers();

    public User getUserById(Long userId);

    public User updateUser(User user) ;

    public String deleteUser(long userId) ;
    public User getUser();
}
