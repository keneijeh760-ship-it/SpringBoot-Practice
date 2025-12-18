package com.phope.hope.Service;

import com.phope.hope.Entity.User;
import com.phope.hope.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findUser(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
