package org.example.mock2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mock2.JWT.AuthService;
import org.example.mock2.JWT.AuthenticationRequest;
import org.example.mock2.JWT.AuthenticationResponse;
import org.example.mock2.JWT.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@Valid @RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@Valid @RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    }
}
