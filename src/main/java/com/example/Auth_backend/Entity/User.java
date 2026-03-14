package com.example.Auth_backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="Users")

public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;



@NotBlank
@Column(nullable = false )
private String firstName ;

@NotBlank
@Column(nullable = false )
private String secondName  ;

@NotBlank
@Column(nullable = false )
private String email;

@NotBlank
@Column(nullable = false )
private String password;

public User (){

}

public User (String firstName ,String secondName , String email , String password){
    this.firstName =firstName;
    this.secondName = secondName ;
    this.email = email;
    this.password= password;
}

public Long getId (){return id ;}

public void setEmail (String email){this.email=email ;}
public String getEmail (){return email ;}

public void setSecondName (String secondName ){ this.secondName = secondName ;}
public String getSecondName (){return secondName ;}

public void setFirstName (String firstName ){ this.firstName = firstName ;}
public String getFirstName (){return firstName ;}

public void setPassword(String password){this.password=password;}
public String getPassword (){return password;}


    
}
