package com.example.Auth_backend.DataTransferObject;

import lombok.Data;

@Data
public class ApiResponse {

    private boolean Success ;
    private String Message ;
    private Object Data;

public ApiResponse(boolean Success , String Message){

    this.Success =Success;
    this.Message =Message ;
}

public ApiResponse(boolean Success , String Message , Object Data ){

    this.Success = Success ;
    this.Message = Message;
    this.Data = Data;
}

}