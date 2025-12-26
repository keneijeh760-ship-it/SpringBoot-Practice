package com.phope.hope.Controller;

import com.phope.hope.DTO.LoginRequestDTO;
import com.phope.hope.DTO.LoginResponseDTO;

import com.phope.hope.Security.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword())
        );

        String token = jwtService.generateToken(request.getEmail());

        return new LoginResponseDTO(token);
    }
}
