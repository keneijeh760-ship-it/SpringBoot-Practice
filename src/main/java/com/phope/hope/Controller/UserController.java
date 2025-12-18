package com.phope.hope.Controller;

import com.phope.hope.Entity.User;
import com.phope.hope.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getUser() {
        return userService.findUser();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
