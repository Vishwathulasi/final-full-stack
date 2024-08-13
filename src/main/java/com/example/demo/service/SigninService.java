// package com.example.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import com.example.demo.model.Signinmodel;
// import com.example.demo.repository.SigninRepo;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class SigninService implements UserDetailsService {
//     @Autowired
//     private SigninRepo userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         Signinmodel user = userRepository.findByEmail(email);
//         if (user != null) {
//             return User.withUsername(user.getEmail())
//                         .password(user.getPassword())
//                         .roles(user.getRole()) // Use the role from your model
//                         .build();
//         } else {
//             throw new UsernameNotFoundException("User not found with email: " + email);
//         }
//     }

//     public Optional<Signinmodel> getUserById(Long id) {
//         return userRepository.findById(id);
//     }

//     public List<Signinmodel> getUserByAll() {
//         return userRepository.findAll();
//     }
// }
