package com.example.Auth_backend.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Auth_backend.DataTransferObject.ApiResponse;
import com.example.Auth_backend.DataTransferObject.SignUpRequest;
import com.example.Auth_backend.DataTransferObject.SigninRequest;
import com.example.Auth_backend.DataTransferObject.UserResponse;
import com.example.Auth_backend.Entity.User;
import com.example.Auth_backend.Repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public AuthService(EmailService emailService, UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    // Sign up Service
    public ApiResponse signUp(SignUpRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return new ApiResponse(false, "Email is already registred . Please sign using a different Email");// making
                                                                                                              // my
                                                                                                              // password
                                                                                                              // hash
                                                                                                              // encoded
        }

        // Creating a new User

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setSecondName(request.getSecondName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        emailService.sendWelcomeEmail(request.getEmail(), request.getFirstName());
        return new ApiResponse(true, "Account created successfully ! Welcome",
                user.getFirstName() + "" + user.getSecondName());

    }

    // Sign in Service
    public ApiResponse signIn(SigninRequest request) {

        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            return new ApiResponse(false, "No account found with this Email ");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            return new ApiResponse(false, "Incorrect password . Please try again");
        }

        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail());

        return new ApiResponse(true,
                "Sign in successful ! Welcome back , " + user.getFirstName() + " " + user.getSecondName() + "!",
                userResponse);

    }
}