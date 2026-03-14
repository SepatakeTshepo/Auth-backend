package com.example.Auth_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Auth_backend.Entity.User;

public interface UserRepository extends JpaRepository <User , Long >{
    
        Optional <User> findByEmail (String email );
        boolean existsByEmail (String email );
    } 

