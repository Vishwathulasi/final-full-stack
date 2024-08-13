// package com.example.demo.controller;
// import java.util.*;
// import java.time.Instant;

// import org.springframework.security.core.Authentication;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
// import org.springframework.security.oauth2.jwt.JwsHeader;
// import org.springframework.security.oauth2.jwt.JwtClaimsSet;
// import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
// import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.FieldError;

// import com.nimbusds.jose.jwk.source.ImmutableSecret;
// import jakarta.validation.Valid;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.Loginmo;
// import com.example.demo.model.Siginmo;
// import com.example.demo.model.Signinmodel;
// import com.example.demo.repository.SigninRepo;
// import com.example.demo.service.SigninService;
// @RestController
// @RequestMapping("/api/user")
// public class Signincontroller {
//     @Autowired
//     private SigninService userService; //check
//     @Autowired
//     private SigninRepo repository;
//     private final AuthenticationManager authenticationManager;

  
//     public Signincontroller(AuthenticationManager authenticationManager) {
//         this.authenticationManager = authenticationManager;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<Object> registerUser(@Valid @RequestBody Siginmo registerDto, BindingResult result) {
//         if (result.hasErrors()) {
//             var errorsMap = new HashMap<String, String>();
//             for (FieldError error : result.getFieldErrors()) {
//                 errorsMap.put(error.getField(), error.getDefaultMessage());
//             }
//             return ResponseEntity.badRequest().body(errorsMap);
//         }

//         var bCryptEncoder = new BCryptPasswordEncoder();
//         Signinmodel userModel = new Signinmodel();

//         userModel.setUsername(registerDto.getUsername());
//         userModel.setEmail(registerDto.getEmail());
//         userModel.setMobileNumber(registerDto.getMobileNumber());
//         userModel.setRole(registerDto.getRole());
//         userModel.setPassword(bCryptEncoder.encode(registerDto.getPassword()));

//         try {
//             if (repository.findByUsername(registerDto.getUsername()) != null) {
//                 return ResponseEntity.badRequest().body("Username already exists");
//             }
//             if (repository.findByEmail(registerDto.getEmail()) != null) {
//                 return ResponseEntity.badRequest().body("Email already exists");
//             }

//             repository.save(userModel);

//             String jwtToken = createJwtToken(userModel);
//             var response = new HashMap<String, Object>();
//             response.put("token", jwtToken);
//             response.put("user", userModel);
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration");
//         }
//     }

//     @GetMapping("/profile")
//     public ResponseEntity<Object> profile(Authentication auth) {
//         var response = new HashMap<String, Object>();
//         response.put("Username", auth.getName());
//         response.put("Authorities", auth.getAuthorities());

//         var appUser = repository.findByUsername(auth.getName());
//         response.put("User", appUser);

//         return ResponseEntity.ok(response);
//     }

// //     @PostMapping("/login")
// // public ResponseEntity<Object> loginUser(@Valid @RequestBody Loginmo loginDto, BindingResult result) {
// //     // Handling validation errors
// //     if (result.hasErrors()) {
// //         var errorsMap = new HashMap<String, String>();
// //         for (FieldError error : result.getFieldErrors()) {
// //             errorsMap.put(error.getField(), error.getDefaultMessage());
// //         }
// //         return ResponseEntity.badRequest().body(errorsMap);
// //     }

// //     try {
// //         // Authenticating the user
// //         authenticationManager.authenticate(
// //                 new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
// //         );

// //         // Fetching the user details
// //         Signinmodel userModel = repository.findByEmail(loginDto.getUsername());
// //         if (userModel == null) {
// //             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
// //         }

// //         // Generating JWT token
// //         String jwtToken = createJwtToken(userModel);

// //         // Preparing the response
// //         var response = new HashMap<String, Object>();
// //         response.put("token", jwtToken);
// //         response.put("user", userModel);
// //         return ResponseEntity.ok(response);

// //     } catch (Exception e) {
// //         // Logging the error and returning an unauthorized response
// //         e.printStackTrace();
// //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
// //     }
// // }

// @PostMapping("/login")
// public ResponseEntity<Object> loginUser(@Valid @RequestBody Loginmo loginDto, BindingResult result) {
//     // Handling validation errors
//     if (result.hasErrors()) {
//         var errorsMap = new HashMap<String, String>();
//         for (FieldError error : result.getFieldErrors()) {
//             errorsMap.put(error.getField(), error.getDefaultMessage());
//         }
//         return ResponseEntity.badRequest().body(errorsMap);
//     }

//     try {
//         // Authenticating the user
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
//         );
        
//         // If authentication is successful, it will reach here
//         Signinmodel userModel = (Signinmodel) authentication.getPrincipal(); // Get authenticated user details

//         if (userModel == null) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//         }

//         // Generating JWT token
//         String jwtToken = createJwtToken(userModel);

//         // Preparing the response
//         var response = new HashMap<String, Object>();
//         response.put("token", jwtToken);
//         response.put("user", userModel);
//         return ResponseEntity.ok(response);

//     } catch (Exception e) {
//         // Logging the error and returning an unauthorized response
//         e.printStackTrace();
//         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//     }
// }



//     @GetMapping("/{id}")
//     public ResponseEntity<Signinmodel> getUserById(@PathVariable Long id) {
//         return userService.getUserById(id)
//                 .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//                 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//     }
    
//     @GetMapping("/all")
//     public List<Signinmodel> getUserByAll() {
//         return userService.getUserByAll();
               
//     }


//     @Value("${security.jwt.secret-key}")
//     private String jwtSecretKey;

//     @Value("${security.jwt.issuer}")
//     private String jwtIssuer;

//     // private String createJwtToken(Signinmodel userModel) {
//     //     Instant now = Instant.now();

//     //     JwtClaimsSet claims = JwtClaimsSet.builder()
//     //             .issuer(jwtIssuer)
//     //             .issuedAt(now)
//     //             .expiresAt(now.plusSeconds(24 * 3600))
//     //             .subject(userModel.getUsername())
//     //             .claim("role", userModel.getRole())
//     //             .build();

//     //     var encoder = new NimbusJwtEncoder(new ImmutableSecret<>(jwtSecretKey.getBytes()));

//     //     var params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);

//     //     return encoder.encode(params).getTokenValue();
//     // }
//     private String createJwtToken(Signinmodel userModel) {
//         Instant now = Instant.now();
    
//         JwtClaimsSet claims = JwtClaimsSet.builder()
//                 .issuer(jwtIssuer)
//                 .issuedAt(now)
//                 .expiresAt(now.plusSeconds(24 * 3600))
//                 .subject(userModel.getUsername())
//                 .claim("role", userModel.getRole())
//                 .build();
    
//         var encoder = new NimbusJwtEncoder(new ImmutableSecret<>(jwtSecretKey.getBytes()));
    
//         var params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
    
//         return encoder.encode(params).getTokenValue();
//     }
    
// }
