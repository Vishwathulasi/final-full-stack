package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

  @Autowired
  private AdminRepository adminRepository;

  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  public Optional<Admin> getAdminById(Long id) {
    return adminRepository.findById(id);
  }

  public Admin addAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  public Admin updateAdmin(Long id, Admin admin) {
    if (adminRepository.existsById(id)) {
      admin.setId(id);
      return adminRepository.save(admin);
    }
    return null;
  }

  public void deleteAdmin(Long id) {
    adminRepository.deleteById(id);
  }

  public Admin authenticateAdmin(String username, String password) {
    return adminRepository.findByUsernameAndPassword(username, password).orElse(null);
  }

  public Admin updatePassword(Long id, String newPassword) {
    Optional<Admin> adminOptional = adminRepository.findById(id);
    if (adminOptional.isPresent()) {
        Admin admin = adminOptional.get();
        admin.setPassword(newPassword);
        return adminRepository.save(admin);
    }
    return null;
}

}
