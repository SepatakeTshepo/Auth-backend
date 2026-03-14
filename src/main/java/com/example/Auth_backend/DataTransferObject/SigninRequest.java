package com.example.Auth_backend.DataTransferObject;

import jakarta.validation.constraints.NotBlank;

public class SigninRequest {

    
    
    private String email;
      @NotBlank
    private String password ;

    public SigninRequest(){}

 public SigninRequest ( String email ,String password ){
   
   this.email =email;
   this.password = password ;


 }

 public void setEmail(String email ){this.email = email ;}
 public String  getEmail (){return email ;}


 public void setPassword (String password ){this.password = password ;}
 public String getPassword (){return password ;}

  
}
    

