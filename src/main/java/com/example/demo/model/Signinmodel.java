// package com.example.demo.model;


// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Signinmodel {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String username;
//     private String email;
//     private String password;
//     private String mobileNumber;
//     private String role;

//     // Constructors, getters, and setters
//     public Signinmodel() {}

//     public Signinmodel(String username, String email, String password, String mobileNumber, String role) {
//         this.username = username;
//         this.email = email;
//         this.password = password;
//         this.mobileNumber = mobileNumber;
//         this.role = role;
//     }

//     // Getters and setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getMobileNumber() {
//         return mobileNumber;
//     }

//     public void setMobileNumber(String mobileNumber) {
//         this.mobileNumber = mobileNumber;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }
// }