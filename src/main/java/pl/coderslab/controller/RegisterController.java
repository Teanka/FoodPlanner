package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Admin;
import pl.coderslab.service.AdminService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    AdminService adminService;

    @GetMapping("/register")
    public String registerForm (Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "registration";
    }

    @PostMapping("/register")
    public String registerAction (@ModelAttribute @Valid Admin admin, BindingResult result) {
        Admin adminExists = adminService.findAdminByEmail(admin.getEmail());
        if (adminExists != null) {
            result.rejectValue("email", "error.user",
                            "Użytkownik z podanym emailem jest już zarejestrowany.");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        if (!admin.getPassword().equals(admin.getPasswordRepeat())) {
            return"registration";
        }
        admin.setEnable(true);
        admin.setSuperAdmin(0);
        adminService.save(admin);
        return "redirect:/login";
    }
}
