package com.phope.hope.Controller;

import com.phope.hope.DTO.UserRequestDTO;
import com.phope.hope.DTO.UserResponseDTO;
import com.phope.hope.Entity.User;
import com.phope.hope.Service.BankingService;
import com.phope.hope.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final BankingService bankingService;

    public UserController(UserService userService, BankingService bankingService){
        this.userService = userService;
        this.bankingService = bankingService;
    }
    @GetMapping("/users")
    public List<User> getUser() {
        return userService.findUser();
    }

    @PostMapping("/users")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO requestDTO) {
        return bankingService.createUser(requestDTO);
    }
}
