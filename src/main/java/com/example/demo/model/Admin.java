package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;
  private String mobileNumber;
  private String profilePicture;
  private String password;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getMobileNumber() {
    return mobileNumber;
  }
  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
  public String getProfilePicture() {
    return profilePicture;
  }
  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }
  public void setPassword(String password)
  {
    this.password=password;
  }
  public String getPassword(){
    return password;
  }
  public Admin() {
    this.password="Admin@2024";
  }
  public Admin(Long id, String username, String email, String mobileNumber, String profilePicture) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.profilePicture = profilePicture;
    this.password="Admin@2024";
  }

  
}
