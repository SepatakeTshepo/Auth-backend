package com.example.Auth_backend.DataTransferObject;




import lombok.Data;

@Data
public class UserResponse{

private Long id ;
private String firstName ;
private String secondName ;
private String email;



public UserResponse(Long id , String firstName , String secondName , String email ){

    this.id = id ;
    this.firstName =firstName;
    this.secondName =secondName ;
    this.email =email;
}



}