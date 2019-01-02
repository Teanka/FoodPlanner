package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Admin;

@Service
@Transactional
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findAdminByEmail(String email);
}
