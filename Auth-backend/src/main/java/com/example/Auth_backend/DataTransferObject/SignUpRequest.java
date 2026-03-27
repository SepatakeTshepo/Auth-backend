package com.example.Auth_backend.DataTransferObject;

import jakarta.validation.constraints.NotBlank;

public class SignUpRequest {

  @NotBlank
  private String firstName;
  @NotBlank
  private String secondName;
  @NotBlank
  private String email;
  @NotBlank
  private String password;

  public SignUpRequest() {
  }

  public SignUpRequest(String firstName, String secondName, String email, String password) {
    this.firstName = firstName;
    this.email = email;
    this.password = password;
    this.secondName = secondName;

  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
