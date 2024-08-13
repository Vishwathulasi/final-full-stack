package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @GetMapping
  public List<Admin> getAllAdmins() {
    return adminService.getAllAdmins();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
    Optional<Admin> admin = adminService.getAdminById(id);
    return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
    return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
    Admin updatedAdmin = adminService.updateAdmin(id, admin);
    return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
    adminService.deleteAdmin(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/login")
  public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
    Admin authenticatedAdmin = adminService.authenticateAdmin(admin.getUsername(), admin.getPassword());
    if (authenticatedAdmin != null) {
      return ResponseEntity.ok(authenticatedAdmin);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
  }

  @PutMapping("/{id}/password")
  public ResponseEntity<Admin> updatePassword(@PathVariable Long id, @RequestBody Map<String, String> passwordMap) {
    String newPassword = passwordMap.get("password");
    Admin updatedAdmin = adminService.updatePassword(id, newPassword);
    return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
  }

}
