// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/api")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/login")
//     public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
//         User user = userService.getUserByUsername(username);
//         if (user != null && password.equals(user.getPassword())) {
//             // Return a success message or a token if using JWT
//             return ResponseEntity.ok(user);
//         } else {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//         }
//     }

// }
