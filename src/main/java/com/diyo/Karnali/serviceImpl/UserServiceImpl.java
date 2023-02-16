package com.diyo.Karnali.serviceImpl;

import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.UserRepository;
import com.diyo.Karnali.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public String deleteUser(long userId) {
        userRepository.deleteById(userId);
        return "user deleted";
    }

    @Override
    public User getUser() {
        return null;
    }
//
//    @Override
//    public User getUser() {
//        return userRepository.;
//    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setAddress(user.getAddress());
        existingUser.setPhone(user.getPhone());
        return userRepository.save(existingUser);
    }

//    public List<User> findById(Long id) {
//        return userRepository.findById(id);
//    }
}
