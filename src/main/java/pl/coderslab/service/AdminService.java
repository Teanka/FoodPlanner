package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dto.RecipeDTO;
import pl.coderslab.model.Admin;
import pl.coderslab.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Admin findAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    public void save(Admin admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }
}
