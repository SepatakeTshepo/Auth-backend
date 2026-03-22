package com.example.Auth_backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Auth_backend.DataTransferObject.ApiResponse;
import com.example.Auth_backend.DataTransferObject.SignUpRequest;
import com.example.Auth_backend.DataTransferObject.SigninRequest;
import com.example.Auth_backend.Service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Auth")
@CrossOrigin(origins = "http://localhost:5174")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignUpRequest request) {

        ApiResponse response = authService.signUp(request);
        return response.isSuccess()
                ? ResponseEntity.status(201).body(response)
                : ResponseEntity.status(409).body(response);

    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> signIn(@Valid @RequestBody SigninRequest request) {
        ApiResponse response = authService.signIn(request);
        return response.isSuccess()
                ? ResponseEntity.ok(response)
                : ResponseEntity.status(401).body(response);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Auth service is");
    }

}
