// package com.example.demo.repository;


// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.Signinmodel;
// import java.util.Optional;

// public interface SigninRepo extends JpaRepository<Signinmodel, Long> {
//     public Signinmodel findByUsername(String username);
//     public Signinmodel findByEmail(String email);
//     boolean existsByEmail(String email);
//     Optional<Signinmodel> findByEmailAndPassword(String email, String password);
// }
